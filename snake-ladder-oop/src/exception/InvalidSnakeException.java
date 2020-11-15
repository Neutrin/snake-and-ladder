package exception;

public class InvalidSnakeException extends Exception{
    public InvalidSnakeException(String reason){
        super(reason);
    }
}
