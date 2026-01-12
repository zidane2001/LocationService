package com.Logistic.LocationService.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Logistic.LocationService.domain.entity.Location;

public interface LocationRepository
    extends MongoRepository<Location, String> {
}