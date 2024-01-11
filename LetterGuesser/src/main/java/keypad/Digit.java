package keypad;

public class Digit {


    private final int value;
    private Color color = Color.BLACK;

    private final Coordinates coordinates;


    public Digit(int value, Coordinates coordinates){
        this.value = value;
        this.coordinates = coordinates;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }
    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }
}
