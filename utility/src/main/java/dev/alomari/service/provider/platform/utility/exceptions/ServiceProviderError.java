package dev.alomari.service.provider.platform.utility.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ServiceProviderError {
    //formatter@off
    NOT_IMPLEMENTED(
            0,
            "service.provider.api.endpoint.not.implemented",
            "Endpoint is not implemented yet",
            HttpStatus.NOT_IMPLEMENTED
    ),

    GENERAL_INTERNAL_ERROR(
            1,
            "service.provider.api.general.internal.error",
            "A general internal error happend in Service Provider API",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    HTTP_METHOD_NOT_SUPPORTED(
            2,
            "service.provider.api.method.not.supported",
            "Your request method is not supported for the desired route",
            HttpStatus.METHOD_NOT_ALLOWED
    ),

    PAGE_NOT_FOUND(
            3,
            "service.provider.api.not.found",
            "Url provided is incorrect",
            HttpStatus.NOT_FOUND
    ),

    INVALID_DATA_INPUT(
            4,
            "service.provider.api.invalid.data.input",
            "Your data input is incorrect",
            HttpStatus.BAD_REQUEST
    ),

    AUTHENTICATION_FAILURE(
            5,
            "service.provider.api.authentication.failure",
            "Credentials are incorrect",
            HttpStatus.UNAUTHORIZED),

    NO_DATA_FOUND(
            6,
            "service.provider.api.no.data.found",
            "No data were found",
            HttpStatus.NOT_FOUND),

    EMAIL_ALREADY_REGISTERED(
            7,
            "service.provider.api.email.already.registered",
            "Email already registered",
            HttpStatus.FORBIDDEN
    ),

    NOT_OWNER_OF_INFO(
            8,
            "service.provider.api.not.owner.of.information",
            "You are not authorized to view other user's private data",
            HttpStatus.FORBIDDEN
    ),

    ORDER_IS_ALREADY_UPDATED(
            9,
            "service.provider.api.order.already.updated",
            "Order is not in Pending state",
            HttpStatus.FORBIDDEN),

    PROPOSAL_IS_ALREADY_UPDATED(
            10,
            "service.provider.api.proposal.already.updated",
            "Proposal is not in Pending state",
            HttpStatus.FORBIDDEN);

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
