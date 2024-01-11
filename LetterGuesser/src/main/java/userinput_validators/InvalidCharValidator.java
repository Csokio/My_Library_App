package userinput_validators;

import exceptions.IncorrectUserInputException;
import exceptions.InvalidCharException;
import exceptions.MissingUserInputException;

public class InvalidCharValidator extends AbstractValidator{

    @Override
    public void validate(String userInput) throws IncorrectUserInputException, MissingUserInputException {

        super.validate(userInput);

        boolean validInput = true;
        for(char c: userInput.toCharArray()){
            if(!Character.isDigit(c)){
                validInput = false;
            }
        }
        if(!validInput){
            throw new InvalidCharException("Just number character allowed!");
        }

    }


}
