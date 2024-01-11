package letter;

import exceptions.IncorrectUserInputException;
import exceptions.MissingUserInputException;
import userinput_validators.InvalidCharValidator;
import userinput_validators.UITooLongValidator;
import userinput_validators.UITooShortValidator;
import userinput_validators.Validator;

import java.util.Scanner;

public class UserInputHandler {

    private final Scanner scanner;
    private final Validator[] validators;

    public boolean isExceptionThrown;

    public UserInputHandler(Scanner scanner){
        this.scanner = scanner;
        validators = new Validator[]{new InvalidCharValidator(),
                new UITooLongValidator(), new UITooShortValidator()};
    }

    public PIN readPinFromUser(){
        boolean correctUserInput;
        String userInput;
        do {
            System.out.print("Please make your tip: ");
            userInput = scanner.nextLine();

            correctUserInput = true;
            isExceptionThrown = false;

            try{
                validateInput(userInput);
                if(!userInput.matches("^\\d{4}$")){
                    correctUserInput = false;
                }
            } catch (MissingUserInputException | IncorrectUserInputException e ) {
                isExceptionThrown = true;
                System.out.println(e.getMessage());
            }

        }   while (!correctUserInput);
        int userNumber = Integer.parseInt(userInput);
        return new PIN(userNumber);
    }

    private void validateInput(String inputNumber) throws IncorrectUserInputException {

        for(Validator validator: validators){
            validator.validate(inputNumber);
        }
    }
}
