package com.Logistic.LocationService.service;

import com.Logistic.LocationService.dto.LocationRequestDto;
import com.Logistic.LocationService.dto.LocationResponseDto;
import com.Logistic.LocationService.dto.PackageResponseDto;
import com.Logistic.LocationService.entity.Location;
import java.util.List;

public interface LocationService {

    LocationResponseDto create(LocationRequestDto request);

    Location getById(String id);

    List<Location> getAll();

    PackageResponseDto getPackageInfo(Long packageId);
}