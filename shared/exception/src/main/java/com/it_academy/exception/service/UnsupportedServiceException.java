package com.it_academy.exception.service;

public class UnsupportedServiceException extends ServiceException{

    public UnsupportedServiceException() {
        super();
    }

    public UnsupportedServiceException(String message) {
        super(message);
    }

    public UnsupportedServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedServiceException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
