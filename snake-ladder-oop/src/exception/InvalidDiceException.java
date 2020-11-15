package exception;

public class InvalidDiceException extends Exception {
    public InvalidDiceException(String reason){
        super(reason);
    }
}