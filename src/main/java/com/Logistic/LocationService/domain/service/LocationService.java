package com.Logistic.LocationService.domain.service;

import com.Logistic.LocationService.domain.dto.LocationRequestDto;
import com.Logistic.LocationService.domain.dto.LocationResponseDto;
import com.Logistic.LocationService.domain.dto.PackageResponseDto;
import com.Logistic.LocationService.domain.entity.Location;
import java.util.List;

public interface LocationService {

    LocationResponseDto create(LocationRequestDto request);

    Location getById(String id);

    List<LocationResponseDto> getAll();

    PackageResponseDto getPackageInfo(Long packageId);
}