package firstproject.com.example.demo.exception;

public class EntityDoesNotExistsException extends RuntimeException {

    public EntityDoesNotExistsException(String message) {
        super(message);
    }
}

