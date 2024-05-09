package org.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(value = {BookException.class})
    public ResponseEntity<String> bookExceptionHandler(BookException bookException) {
        return new ResponseEntity<String>(bookException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
