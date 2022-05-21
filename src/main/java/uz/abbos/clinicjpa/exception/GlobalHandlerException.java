package uz.abbos.clinicjpa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler
    public ResponseEntity<?> myException(BadRequestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
