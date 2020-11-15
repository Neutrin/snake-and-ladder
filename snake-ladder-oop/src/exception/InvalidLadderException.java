package exception;

public class InvalidLadderException extends Exception {
    public InvalidLadderException(String reason){
        super(reason);
    }
}