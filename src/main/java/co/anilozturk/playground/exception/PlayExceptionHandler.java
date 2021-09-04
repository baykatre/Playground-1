package co.anilozturk.playground.exception;

import co.anilozturk.playground.generic.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayExceptionHandler {

    @ExceptionHandler(PlayException.class)
    ResponseEntity<?> handle(PlayException e){
        final String errorCode = e.getCode();

        return getInternalServerErrorResponse(errorCode);
    }

    private ResponseEntity<?> getInternalServerErrorResponse(Object unknownError) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Response.from(unknownError));
    }
}
