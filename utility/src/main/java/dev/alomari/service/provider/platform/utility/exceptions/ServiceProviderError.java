package dev.alomari.service.provider.platform.utility.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ServiceProviderError {
    //formatter@off
    GENERAL_INTERNAL_ERROR(
            -1,
            "service.provider.api.general.internal.error",
            "A general internal error happend in Service Provider API",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    HTTP_METHOD_NOT_SUPPORTED(
            0,
            "service.provider.api.method.not.supported",
            "Your request method is not supported for the desired route",
            HttpStatus.METHOD_NOT_ALLOWED
    ),

    PAGE_NOT_FOUND(
            1,
            "service.provider.api.not.found",
            "Url provided is incorrect",
            HttpStatus.NOT_FOUND
    ),

    INVALID_DATA_INPUT(
            2,
            "service.provider.api.invalid.data.input",
            "Your data input is incorrect",
            HttpStatus.BAD_REQUEST
    ),

    //formatter@on
    ;
    private int code;
    private String key;
    private String message;
    private HttpStatus httpStatus;

    ServiceProviderError(int code, String key, String message, HttpStatus httpStatus) {
        this.code = code;
        this.key = key;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
