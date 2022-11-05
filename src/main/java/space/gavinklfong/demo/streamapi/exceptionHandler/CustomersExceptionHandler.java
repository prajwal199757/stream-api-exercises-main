package space.gavinklfong.demo.streamapi.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import space.gavinklfong.demo.streamapi.exceptions.RecordNotFoundException;

@RestControllerAdvice
public class CustomersExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleNonExistingEmp(RecordNotFoundException exception) {
        return new ResponseEntity<>("the customer details do not exists in database", HttpStatus.OK);
    }
}
