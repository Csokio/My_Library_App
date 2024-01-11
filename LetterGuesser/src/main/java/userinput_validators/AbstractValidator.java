package userinput_validators;

import exceptions.IncorrectUserInputException;
import exceptions.MissingUserInputException;

public abstract class AbstractValidator implements Validator{

    @Override
    public void validate(String userInput) throws IncorrectUserInputException, MissingUserInputException {

        if(userInput.length() == 0){
            throw new MissingUserInputException("No input is given. Please provide a four integer long input!");
        }
    }
}
