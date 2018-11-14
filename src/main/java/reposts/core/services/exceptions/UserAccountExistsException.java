package reposts.core.services.exceptions;

public class UserAccountExistsException extends RuntimeException {

    public UserAccountExistsException(String message){
        super(message);
    }
}
