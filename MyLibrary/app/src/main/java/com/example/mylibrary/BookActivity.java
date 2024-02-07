package com.example.mylibrary;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";
    private TextView txtBookName, txtAuthor, txtPages, txtLongDescription, txtShortDescription;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToCurrentReading, btnAddToFavorites;
    private ImageView bookImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();


        Intent intent = getIntent();
        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if(null != incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);

                }
            }
        }


    }

    private void handleFavoriteBooks(final Book book) {
        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoriteBooks();

        boolean existInFavorites = false;

        for(Book b: favoriteBooks){
            if(b.getId() == book.getId()){
                existInFavorites = true;
            }
        }

        if (existInFavorites){
            btnAddToFavorites.setEnabled(false);
        }   else {
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToFavorites(book)){
                        Toast.makeText(BookActivity.this, "Book Added To Favorites", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavoriteBookActivity.class);
                        startActivity(intent);
                    }   else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }

    private void handleCurrentlyReadingBooks(final Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existAlreadyInCurrentlyReading = false;

        for(Book b: currentlyReadingBooks){
            if(b.getId() == book.getId()){
                existAlreadyInCurrentlyReading = true;
            }
        }

        if(existAlreadyInCurrentlyReading){
            btnAddToCurrentReading.setEnabled(false);
        }   else {
            btnAddToCurrentReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this, "Book Added To Currently Reading Ones", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurReadBookActivity.class);
                        startActivity(intent);
                    }   else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

        boolean existInWantToRead = false;

        for(Book b: wantToReadBooks){
            if(b.getId() == book.getId()){
                existInWantToRead = true;
            }
        }

        if(existInWantToRead){
            btnAddToWantToRead.setEnabled(false);
        }   else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToWishList(book)){
                        Toast.makeText(BookActivity.this, "Book is Added To" +
                                " Your Wishlist", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }   else {
                        Toast.makeText(BookActivity.this, "Something wrong happened" +
                                ", please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void handleAlreadyRead(final Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for(Book b: alreadyReadBooks){
            if(b.getId() == book.getId()){
                existInAlreadyReadBooks = true;
            }
        }

        if(existInAlreadyReadBooks){
            btnAddToAlreadyRead.setEnabled(false);
        }   else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }   else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtPages.setText(String.valueOf(book.getPages()));
        txtAuthor.setText(book.getAuthor());
        txtLongDescription.setText(book.getLongDesc());
        txtShortDescription.setText(book.getShortDesc());

        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews() {
        txtAuthor = findViewById(R.id.txtOurAuthorName);
        txtLongDescription = findViewById(R.id.txtOurBookLongDesc);
        txtShortDescription = findViewById(R.id.txtOurBookShortDesc);
        txtPages = findViewById(R.id.txtOurPagesNumber);
        txtBookName = findViewById(R.id.txtOurBookName);

        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToWantToRead = findViewById(R.id.btnAddToWishList);
        btnAddToCurrentReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);

        bookImage = findViewById(R.id.imgOfOurBook);
    }
}