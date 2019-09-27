package dev.alomari.service.provider.platform.controller.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ServiceProviderExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceProviderException.class)
    protected ResponseEntity<Object> handleServiceProviderException(ServiceProviderException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(exception);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServiceProviderException exception = new ServiceProviderException(ServiceProviderError.HTTP_METHOD_NOT_SUPPORTED);
        return ResponseEntity.status(exception.getHttpStatus()).body(exception);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServiceProviderException exception = new ServiceProviderException(ServiceProviderError.PAGE_NOT_FOUND);
        return ResponseEntity.status(exception.getHttpStatus()).body(exception);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServiceProviderException exception = new ServiceProviderException(ServiceProviderError.INVALID_DATA_INPUT);
        return ResponseEntity.status(exception.getHttpStatus()).body(exception);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServiceProviderException exception = new ServiceProviderException(ServiceProviderError.INVALID_DATA_INPUT);
        return ResponseEntity.status(exception.getHttpStatus()).body(exception);
    }
}
