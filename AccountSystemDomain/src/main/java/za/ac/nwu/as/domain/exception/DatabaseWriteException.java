package za.ac.nwu.as.domain.exception;

public class DatabaseWriteException extends RuntimeException{
    public DatabaseWriteException(String message) {
        super(message);
    }
}
