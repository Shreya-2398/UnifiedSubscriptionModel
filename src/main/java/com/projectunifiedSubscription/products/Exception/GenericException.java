package com.projectunifiedSubscription.products.Exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException{
    private HttpStatus status;

    public GenericException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
