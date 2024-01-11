package keypad;

import letter.GameState;

import java.util.Map;
import java.util.Objects;

public class UpdateKeypad extends KeyPad{

    private final GameState gameState;

    public UpdateKeypad(GameState gameState) {
        super();
        this.gameState = gameState;
    }

    public void setColorOfKeyPad()
    {
        Map<Integer, Integer> solution = gameState.getCompareGuessWithSolution();
        for (Map.Entry<Integer, Integer> entry : solution.entrySet()) {
            if(Objects.equals(entry.getKey(), entry.getValue())){
                getDigits().get(gameState.getGuess().getDigits().get(entry.getKey())).setColor(Color.GREEN);
            } else if (entry.getValue() == -1) {
                getDigits().get(gameState.getGuess().getDigits().get(entry.getKey())).setColor(Color.RED);
            } else {
                getDigits().get(gameState.getGuess().getDigits().get(entry.getKey())).setColor(Color.YELLOW);
            }
        }

    }

    public boolean isGameEnded(GameState gameState)
    {
        // Without counter, gameState.getGuess() would throw null pointer exception at first iteration
        //      in the while circle in App class.
        int counter = 0;
        for (Map.Entry<Integer, Digit> entry : getDigits().entrySet()) {
            if(entry.getValue().getColor() == Color.GREEN){
                counter++;
            }
        }

        int correctGuessListSize = 0;
        if(counter > 1){
            correctGuessListSize = gameState.getGuess().getCorrectValueCorrectLocation().size();
        }

        return correctGuessListSize == 4;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
