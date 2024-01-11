package letter;

import static org.fusesource.jansi.Ansi.ansi;

public class AnsiString {

    private final String text;

    public AnsiString(String text){
        this.text = text;
    }

    public AnsiString(Integer number) {
        this(number.toString());
    }

    public String inRed(){
        String redText =  ansi().fgBrightRed().a(text).toString();
        redText += "\u001B[0m";
        return redText;
    }
    public String inYellow(){
        String yellowText = ansi().fgBrightYellow().a(text).toString();
        yellowText += "\u001B[0m";
        return yellowText;
    }
    public String inGreen(){
        String greenText = ansi().fgBrightGreen().a(text).toString();
        greenText += "\u001B[0m";
        return greenText;
    }
}
