package letter;

import keypad.UpdateKeypad;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            new App().run(scanner);

        }
    }

    private void run(Scanner scanner){
        PIN solution = new SolutionGenerator().generateSolution();
        System.out.println(solution);

        GameState gameState = new GameState(solution);

        UpdateKeypad updateKeypad = new UpdateKeypad(gameState);

        while(!updateKeypad.isGameEnded(gameState)){
            UserInputHandler in = new UserInputHandler(scanner);
            PIN pin = in.readPinFromUser();
            if(!in.isExceptionThrown){
                gameState.update(pin);
                updateKeypad.setColorOfKeyPad();
                System.out.println(updateKeypad);
                System.out.println(gameState);
            }
        }
        System.out.println("CONGRATULATION YOU'VE WON THE GAME :))");
    }
}
