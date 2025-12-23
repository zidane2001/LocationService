package com.Logistic.LocationService.exception;

public class LocationNotFoundException
        extends RuntimeException {

    public LocationNotFoundException(String id) {
        super("Location not found with id: " + id);
    }
}