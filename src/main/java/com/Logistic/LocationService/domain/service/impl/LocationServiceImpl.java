package com.Logistic.LocationService.domain.service.impl;

import com.Logistic.LocationService.core.feign.PackageFeignClient;
import com.Logistic.LocationService.domain.dto.LocationRequestDto;
import com.Logistic.LocationService.domain.dto.LocationResponseDto;
import com.Logistic.LocationService.domain.dto.PackageResponseDto;
import com.Logistic.LocationService.domain.entity.Location;
import com.Logistic.LocationService.domain.exception.LocationNotFoundException;
import com.Logistic.LocationService.domain.exception.PackageServiceUnavailableException;
import com.Logistic.LocationService.domain.mapper.LocationMapper;
import com.Logistic.LocationService.domain.repository.LocationRepository;
import com.Logistic.LocationService.domain.service.LocationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.List;
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
        return mapper.toDto(repository.save(location));
    }

    @Override
    public LocationResponseDto getById(String id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    @Override
    public List<LocationResponseDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @CircuitBreaker(name = "packageService", fallbackMethod = "getPackageInfoFallback")
    @Retry(name = "packageService")
    public PackageResponseDto getPackageInfo(Long packageId) {
        return packageFeignClient.getById(packageId);
    }

    private PackageResponseDto getPackageInfoFallback(Long packageId, Throwable throwable) {
        throw new PackageServiceUnavailableException(
                "Package service is currently unavailable for package ID: " + packageId, throwable);
    }
}