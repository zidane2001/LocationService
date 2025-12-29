package com.Logistic.LocationService.domain.repository;

import com.Logistic.LocationService.domain.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository
                extends MongoRepository<Location, String> {
}