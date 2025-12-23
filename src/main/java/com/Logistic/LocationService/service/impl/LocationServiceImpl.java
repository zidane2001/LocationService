package com.Logistic.LocationService.service.impl;

import com.Logistic.LocationService.dto.LocationRequestDto;
import com.Logistic.LocationService.dto.LocationResponseDto;
import com.Logistic.LocationService.dto.PackageResponseDto;
import com.Logistic.LocationService.entity.Location;
import com.Logistic.LocationService.exception.LocationNotFoundException;
import com.Logistic.LocationService.feign.PackageFeignClient;
import com.Logistic.LocationService.mapper.LocationMapper;
import com.Logistic.LocationService.repository.LocationRepository;
import com.Logistic.LocationService.service.LocationService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;
    private final LocationMapper mapper;
    private final PackageFeignClient packageFeignClient;

    @Override
    public LocationResponseDto create(LocationRequestDto request) {
        Location location = mapper.toEntity(request);
        location.setLocationId(UUID.randomUUID().toString());
        return mapper.toDto(repository.save(location));
    }

    @Override
    public Location getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }

    @Override
    public PackageResponseDto getPackageInfo(Long packageId) {
        return packageFeignClient.getById(packageId);
    }
}