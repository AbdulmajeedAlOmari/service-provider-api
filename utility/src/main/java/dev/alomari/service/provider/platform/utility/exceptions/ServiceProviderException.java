package dev.alomari.service.provider.platform.utility.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonIgnoreProperties({ "cause", "stackTrace", "localizedMessage", "suppressed" })
public class ServiceProviderException extends RuntimeException {
    private int code;
    private String key;
    private String message;
    private HttpStatus httpStatus;

    public ServiceProviderException(ServiceProviderError error) {
        this.code = error.getCode();
        this.key = error.getKey();
        this.message = error.getMessage();
        this.httpStatus = error.getHttpStatus();
    }
}
