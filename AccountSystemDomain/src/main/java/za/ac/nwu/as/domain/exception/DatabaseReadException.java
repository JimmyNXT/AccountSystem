package za.ac.nwu.as.domain.exception;

public class DatabaseReadException extends RuntimeException{

    public DatabaseReadException(String message) {
        super(message);
    }
}
