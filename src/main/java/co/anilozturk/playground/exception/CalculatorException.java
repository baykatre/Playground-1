package co.anilozturk.playground.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class CalculatorException extends PlayException{

    CalculatorException(Exception exception) {
        super(exception);
    }

    public CalculatorException(String code, Object... messages) {
        super(code, messages);
    }
}
