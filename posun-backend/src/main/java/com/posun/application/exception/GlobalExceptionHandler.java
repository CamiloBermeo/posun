package com.posun.application.exception;

import com.posun.application.exception.tenant.FindTenantByIdNotFound;
import com.posun.application.exception.tenant.TenantIsPresentException;
import com.posun.application.exception.tenant.TenantNotFoundException;
import com.posun.application.exception.valueObject.InformationNotNullException;
import com.posun.application.exception.valueObject.InvalidCancellationHoursException;
import com.posun.application.exception.valueObject.InvalidPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({TenantNotFoundException.class, FindTenantByIdNotFound.class, InformationNotNullException.class})
    public ResponseEntity<ErrorDetails> handleNotFound(RuntimeException ex) {
        return buildResponse(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TenantIsPresentException.class)
    public ResponseEntity<ErrorDetails> handleTenantIsPresentException(TenantIsPresentException ex) {
        return buildResponse(ex, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCancellationHoursException.class)
    public ResponseEntity<ErrorDetails> handleInvalidCancellationHoursException(InvalidCancellationHoursException ex) {
        return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<ErrorDetails> handleInvalidPriceException(InvalidPriceException ex) {
        return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }


    public record ErrorDetails(int status, String message) {
        public ErrorDetails(int status, String message) {
            this.status = status;
            this.message = message;
        }
    }

    private ResponseEntity<ErrorDetails> buildResponse(Exception ex, HttpStatus status) {
        ErrorDetails error = new ErrorDetails(status.value(), ex.getMessage());
        return new ResponseEntity<>(error, status);
    }
}
