package com.Logistic.LocationService.repository;

import com.Logistic.LocationService.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository
        extends MongoRepository<Location, String> {
}