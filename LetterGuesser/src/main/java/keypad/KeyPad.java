package keypad;

import letter.AnsiString;

import java.util.HashMap;
import java.util.Map;

public class KeyPad {


    private final Map<Integer, Digit> digits = new HashMap<>();

    public Map<Integer, Digit> getDigits() {
        return digits;
    }


    public KeyPad(){

        digits.put(7, new Digit(7, new Coordinates(0,0)));
        digits.put(8, new Digit(8, new Coordinates(0,2)));
        digits.put(9, new Digit(9, new Coordinates(0,4)));
        digits.put(4, new Digit(4, new Coordinates(1,0)));
        digits.put(5, new Digit(5, new Coordinates(1,2)));
        digits.put(6, new Digit(6, new Coordinates(1,4)));
        digits.put(1, new Digit(1, new Coordinates(2,0)));
        digits.put(2, new Digit(2, new Coordinates(2,2)));
        digits.put(3, new Digit(3, new Coordinates(2,4)));
        digits.put(0, new Digit(0, new Coordinates(3,2)));

    }

    public void setColorOfDigit(Integer digit, Color color){
        digits.get(digit).setColor(color);
    }

    private void fillBufferWithDigits(String[][] printBuffer) {
        for(Digit digit: digits.values()){
            Coordinates coordinates = digit.getCoordinates();
            String value = switch (digit.getColor()){
                case GREEN -> new AnsiString(Integer.toString(digit.getValue())).inGreen();
                case YELLOW -> new AnsiString(Integer.toString(digit.getValue())).inYellow();
                case RED -> new AnsiString(Integer.toString(digit.getValue())).inRed();
                default -> Integer.toString(digit.getValue());
            };
            printBuffer[coordinates.getRow()][coordinates.getCol()] = value;
        }

    }

    private void fillBufferWithBlank(String[][] printBuffer) {
        for(int row = 0; row < printBuffer.length; row++){
            for(int col = 0; col < printBuffer[row].length; col++){
                printBuffer[row][col] = " ";
            }
        }
    }


    private int getMaximumRowIndex(){
        int max = 0;
        for(Digit digit: digits.values()){
            if(digit.getCoordinates().getRow() > max){
                max = digit.getCoordinates().getRow();
            }
        }
        return max;
    }

    private int getMaximumColIndex(){
        int max = 0;
        for(Digit digit: digits.values()){
            if(digit.getCoordinates().getCol() > max){
                max = digit.getCoordinates().getCol();
            }
        }
        return max;
    }

    @Override
    public String toString() {
        int maxRowIndex = getMaximumRowIndex();
        int maxColIndex = getMaximumColIndex();
        int numberOfRows = maxRowIndex+1;
        int numberOfCols = maxColIndex+1;

        String[][] printBuffer = new String[numberOfRows][numberOfCols];
        fillBufferWithBlank(printBuffer);
        fillBufferWithDigits(printBuffer);

        StringBuilder builder = new StringBuilder();
        for(int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                builder.append(printBuffer[row][col]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
