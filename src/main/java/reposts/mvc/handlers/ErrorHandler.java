package reposts.mvc.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(SalesChannelNullException.class)
    public ResponseEntity<Object> handle(SalesChannelNullException ex){
        String body = ex.getMessage();
        return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
    }
}
