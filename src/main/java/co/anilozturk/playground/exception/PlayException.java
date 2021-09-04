package co.anilozturk.playground.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PlayException extends RuntimeException{

    private final String code;

    private final Object[] messages;

    PlayException(Exception exception) {
        super(exception.getMessage(), exception);
        this.code = null;
        this.messages = null;
    }

    PlayException(String code, Object... messages) {

        this.code = code;
        this.messages = messages;
    }

    public Optional<String> getErrorCode() {

        return Optional.ofNullable(this.code);
    }

    public Optional<Object[]> getMessages() {

        return Optional.ofNullable(this.messages);
    }
}
