package co.anilozturk.playground.generic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {

    private T data;

    private String message;

    public Response(T data) {

        this.data = data;
        this.message = "Have a nice day!";
    }

    public static <T> Response<T> from(T t){
        return new Response<>(t);
    }
}
