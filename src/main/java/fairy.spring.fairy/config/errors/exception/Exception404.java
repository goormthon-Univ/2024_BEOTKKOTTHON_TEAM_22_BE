package fairy.spring.fairy.config.errors.exception;


import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import lombok.Getter;

@Getter
public class Exception404 extends RuntimeException {
    public Exception404(String message) {
        super(message);
    }

    public ApiResponseBuilder.ApiResponse<?> body(){
        return ApiResponseBuilder.error(getMessage());
    }
}