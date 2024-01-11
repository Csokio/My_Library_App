package letter;

import java.util.*;

public class PIN {

    private final List<Integer> digits = new ArrayList<>(4);
    private final List<Integer> correctValueCorrectLocation = new ArrayList<>(4);
    private final List<Integer> correctValueInCorrectLocation = new ArrayList<>(4);
    private final List<Integer> inCorrectValue = new ArrayList<>(4);

    private List<List<Integer>> culminateGuesses = new LinkedList<>(Arrays.asList(correctValueCorrectLocation,
            correctValueInCorrectLocation, inCorrectValue));

    private void addElementsToCulminateGuesses(){
        culminateGuesses = List.of(inCorrectValue, correctValueInCorrectLocation);

    }

    public List<List<Integer>> getCulminateGuesses() {
        return culminateGuesses;
    }

    public List<Integer> getCorrectValueCorrectLocation() {
        return correctValueCorrectLocation;
    }

    public List<Integer> getCorrectValueInCorrectLocation() {
        return correctValueInCorrectLocation;
    }

    public List<Integer> getInCorrectValue() {
        return inCorrectValue;
    }



    public List<Integer> getDigits(){
        return this.digits;
    }
    public PIN(int userNumber) {
        int remainder = userNumber;
        while(remainder != 0){
            int currentDigit = remainder % 10;
            digits.add(0, currentDigit);
            remainder /= 10;
        }
        while(digits.size() < 4){
            digits.add(0, 0);
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for(Integer digit: digits){
            stringJoiner.add(digit.toString());
        }
        return stringJoiner.toString();
    }
}
