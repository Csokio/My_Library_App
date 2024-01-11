package letter;

import java.util.*;

public class GameState {

    private final PIN solution;

    private PIN guess;

    private final List<String> operators = new ArrayList<>(4);

    private final Map<Integer, Integer> compareGuessWithSolution = new HashMap<>();

    public Map<Integer, Integer> getCompareGuessWithSolution() {
        return compareGuessWithSolution;
    }

    public PIN getGuess() {
        return guess;
    }


    public GameState(PIN solution) {
        this.solution = solution;
        List<Integer> digits = solution.getDigits();
        Iterator<Integer> iterator = digits.iterator();
        Integer previous = iterator.next();
        /*or (Integer current = iterator.next(); iterator.hasNext();
             previous = current, current = iterator.next()){
            if(previous < current){
                operators.add("<");
            } else if (previous > current){
                operators.add(">");
            } else {
                operators.add("=");
            }
        }*/

        do {
            Integer current = iterator.next();
            if(previous < current){
                operators.add("<");
            } else if (previous > current){
                operators.add(">");
            } else {
                operators.add("=");
            }
            previous = current;
        } while (iterator.hasNext());
        System.out.println(operators);
    }

    public void update(PIN guess) {
        this.guess = guess;
        for(int i = 0; i < 4; i++){
            if(Objects.equals(solution.getDigits().get(i), guess.getDigits().get(i))){
                guess.getCorrectValueCorrectLocation().add(guess.getDigits().get(i));
                compareGuessWithSolution.put(i,i);
            }
            if(!Objects.equals(solution.getDigits().get(i), guess.getDigits().get(i))){
                boolean foundCorrectValueIncorrectLocation = false;
                if(i < 3){
                    for(int j = i+1; j < 4; j++){
                       if(Objects.equals(solution.getDigits().get(j), guess.getDigits().get(i)) ||
                               guess.getCorrectValueCorrectLocation().contains(guess.getDigits().get(i))){
                           guess.getCorrectValueInCorrectLocation().add(guess.getDigits().get(i));
                           compareGuessWithSolution.put(i,j);
                           foundCorrectValueIncorrectLocation = true;
                       }

                    }
                }
                if(solution.getDigits().contains(guess.getDigits().get(i))  && !foundCorrectValueIncorrectLocation){
                    compareGuessWithSolution.put(i,i-1);
                    foundCorrectValueIncorrectLocation = true;
                }
                if(!foundCorrectValueIncorrectLocation){
                    guess.getInCorrectValue().add(guess.getDigits().get(i));
                    compareGuessWithSolution.put(i,-1);
                }

            }
        }


    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : compareGuessWithSolution.entrySet()) {
            if(entry.getValue() == entry.getKey()){
                builder.append(new AnsiString(solution.getDigits().get(i)).inGreen());
            }   else {
                if(entry.getValue() != -1){
                    builder.append(new AnsiString(guess.getDigits().get(i)).inYellow());
                } else {
                    builder.append(new AnsiString(guess.getDigits().get(i)).inRed());
                }
            }
            if(i < operators.size()){
                builder.append(" ");
                builder.append(operators.get(i));
                builder.append(" ");
            }
            i++;
        }

        builder.append('\n');

        return builder.toString();
    }

}
