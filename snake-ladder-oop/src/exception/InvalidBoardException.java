package exception;


public class InvalidBoardException extends Exception {
    public InvalidBoardException(String reason){
        super(reason);
    }
}