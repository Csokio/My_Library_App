package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

public class Utils {

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_books";


    private static Utils instance;

    private SharedPreferences sharedPreferences;

    /*private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;*/

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY,
                null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS,
                null), type);
        return books;
    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS,
                null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS,
                null), type);
        return books;
    }

    public ArrayList<Book> getFavoriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS,
                null), type);
        return books;
    }

    private Utils(Context context){

        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(null == getAllBooks()){
            initData();
        }


        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if(null == getAlreadyReadBooks()){
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getCurrentlyReadingBooks()){
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getFavoriteBooks()){
            editor.putString(FAVORITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }


    public static synchronized Utils getInstance(Context context){
        if (null == instance) {
            instance = new Utils(context);

        }
        return instance;
    }


    private void initData() {

        ArrayList<Book> books = new ArrayList<>();


        books.add(new Book(1, "Soul", "Olivia Wilson", 492,
                "https://marketplace.canva.com/EAFaQMYuZbo/1/0/" +
                        "1003w/canva-brown-rusty-mystery-novel-book-cover-hG1QhA7BiBU.jpg",
                "This book invites you to a journey", "“Soul” by Olivia Wilson delves into the essence " +
                "of human existence. This novel invites readers to explore the depths of the soul, " +
                "where emotions, experiences, and aspirations converge. Follow the characters on a transformative " +
                "journey, where the true essence of humanity is laid bare, creating a narrative " +
                "that resonates with the universal threads that bind us all."));

        books.add(new Book(2, "Harry Potter", "J.K. Rowling", 566,
                "https://m.media-amazon.com/images/I/71MUiF4iVzL._AC_UF894,1000_QL80_.jpg",
                "A fascinating story", longDescHolder(2)));

        books.add(new Book(3,"The Lion King", "Irene Mecchi", 76,
                "https://m.media-amazon.com/images/I/81x1-7zDMsL._AC_UF1000,1000_QL80_.jpg",
                "What really sits at the heart of the Lion King story is the ability to forgive ourselves for the past",
                longDescHolder(3)));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.commit();
    }

    public Book getBookById(int id){
        ArrayList<Book> books = getAllBooks();
        if(null != books){
            for(Book b: books){
                if(b.getId() == id){
                    return b;
                }
            }
        }
        return null;
    }

    public String longDescHolder(int id){

        Map<Integer, String> collectorMap = new HashMap<>();
        String longDescriptionID2 = "The plot follows Harry's second year at Hogwarts \" +\n" +
                "                \"School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's \" +\n" +
                "                \"corridors warn that the \\\"Chamber of Secrets\\\" has been opened and that the \\\"heir of Slytherin\\\" \" +\n" +
                "                \"would kill all pupils who do not come from all-magical families. Vestibulum sit amet nisi justo. In in\" +\n" +
                "                \" rhoncus justo. Aenean vestibulum lacinia consequat. Aenean sodales ligula sit amet quam sodales, at \" +\n" +
                "                \"pharetra quam vestibulum. Praesent id elementum sem. Fusce rhoncus consequat blandit. Nullam gravida\" +\n" +
                "                \"dapibus justo, sed sodales lorem elementum ac. Nunc placerat euismod enim eget blandit. Mauris interdum,\" +\n" +
                "                \" mauris vehicula blandit pharetra, lorem ex placerat enim, nec tincidunt arcu lorem eget nunc. Nunc semper aliquet \" +\n" +
                "                \"diam eu porttitor. Mauris justo velit, tristique vel viverra at, semper sit amet sem." +
                "                  A fascinating story\", \"The plot follows Harry's second year at Hogwarts \" +\n" +
                "                \"School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's \" +\n" +
                "                \"corridors warn that the \\\"Chamber of Secrets\\\" has been opened and that the \\\"heir of Slytherin\\\" \" +\n" +
                "                \"would kill all pupils who do not come from all-magical families. Vestibulum sit amet nisi justo. In in\" +\n" +
                "                \" rhoncus justo. Aenean vestibulum lacinia consequat. Aenean sodales ligula sit amet quam sodales, at \" +\n" +
                "                \"pharetra quam vestibulum. Praesent id elementum sem. Fusce rhoncus consequat blandit. Nullam gravida\" +\n" +
                "                \"dapibus justo, sed sodales lorem elementum ac. Nunc placerat euismod enim eget blandit. Mauris interdum,\" +\n" +
                "                \" mauris vehicula blandit pharetra, lorem ex placerat enim, nec tincidunt arcu lorem eget nunc. Nunc semper aliquet \" +\n" +
                "                \"diam eu porttitor. Mauris justo velit, tristique vel viverra at, semper sit amet sem." +
                "                       A fascinating story\", \"The plot follows Harry's second year at Hogwarts \" +\n" +
                "                \"School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's \" +\n" +
                "                \"corridors warn that the \\\"Chamber of Secrets\\\" has been opened and that the \\\"heir of Slytherin\\\" \" +\n" +
                "                \"would kill all pupils who do not come from all-magical families. Vestibulum sit amet nisi justo. In in\" +\n" +
                "                \" rhoncus justo. Aenean vestibulum lacinia consequat. Aenean sodales ligula sit amet quam sodales, at \" +\n" +
                "                \"pharetra quam vestibulum. Praesent id elementum sem. Fusce rhoncus consequat blandit. Nullam gravida\" +\n" +
                "                \"dapibus justo, sed sodales lorem elementum ac. Nunc placerat euismod enim eget blandit. Mauris interdum,\" +\n" +
                "                \" mauris vehicula blandit pharetra, lorem ex placerat enim, nec tincidunt arcu lorem eget nunc. Nunc semper aliquet \" +\n" +
                "                \"diam eu porttitor. Mauris justo velit, tristique vel viverra at, semper sit amet sem.";
        longDescriptionID2 = longDescriptionID2.replaceAll("[^a-zA-Z\\s,\\.]", "").replaceAll("\\s+", " ");
        collectorMap.put(2,longDescriptionID2);

        String longDescriptionID3 = "Simba, exhausted in the desert, is rescued by a meerkat and a warthog, Timon and Pumbaa. He grows up with them in the" +
                " jungle, learning to create a carefree life and adopting a new motto, “Hakuna Matata,” meaning “no worries.” One day, a hungry lioness" +
                " comes to hunt Timon and Pumbaa. Simba intercepts her, discovering that she is Nala. They fall back in love and Nala tells him to" +
                " come home, conveying that the Pride Lands have fallen into drought and despair. Simba refuses and runs away, unwilling to cope with" +
                " returning to the site of his father’s death. He finds Rafiki, who says that Mufasa is still alive in Simba. Mufasa’s spirit appears" +
                " in the stars, telling Simba that he must live on as king. Simba is convinced to return home.\n" +
                "\n" +
                "Simba covertly returns to Pride Rock, confronting Scar. Scar tries to exploit Simba’s insecurity about his role in Mufasa’s death, backing" +
                " him to the edge of Pride Rock. There, he reveals that he killed Mufasa. Overcome with anger, Simba throws himself onto Scar, pinning him down." +
                " He forces Scar to announce the truth to the pride. His friends Timon and Pumbaa, along with Rafiki, Zazu, and the lionesses, fight off the hyenas " +
                "while Scar tries to escape. Simba corners him, and Scar begs for mercy, offering to betray his hyenas. Simba agrees on the condition that Scar is" +
                " banished from the Pride Lands. Scar tries to attack again, and Simba throws him from the rock. He survives the fall but is killed by the hyenas " +
                "who overheard his betrayal. Rain begins to fall as Simba regains the kingship, and life comes back to the Pride Lands. The book concludes as Rafiki" +
                " holds up Simba and Nala’s new cub to the assembly of animals, repeating the circle of life.\n" +
                "\n" +
                "A classic coming of age story, The Lion King incorporates the symbolism of the animal kingdom and its natural hierarchical structure to present " +
                "the struggle of its protagonist as a return to his inherited home, family, and throne.";
        longDescriptionID3 = longDescriptionID3.replaceAll("[^a-zA-Z\\s,\\.]", "").replaceAll("\\s+", " ");
        collectorMap.put(3,longDescriptionID3);
        return collectorMap.get(id);
    }

    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToWishList(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
    public boolean addToFavorites(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            for(Book b: books){
                if(book.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromFavorites(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if(null != books){
            for(Book b: books){
                if(book.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if(null != books){
            for(Book b: books){
                if(book.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFromWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(null != books){
            for(Book b: books){
                if(book.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;    }

}
