package com.Logistic.LocationService.domain.exception;

public class PackageServiceUnavailableException extends RuntimeException {

    public PackageServiceUnavailableException(String message) {
        super(message);
    }

    public PackageServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}