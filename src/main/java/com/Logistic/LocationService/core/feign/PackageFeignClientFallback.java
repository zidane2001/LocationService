package com.Logistic.LocationService.core.feign;

import com.Logistic.LocationService.domain.dto.PackageResponseDto;
import com.Logistic.LocationService.domain.exception.PackageServiceUnavailableException;

public class PackageFeignClientFallback implements PackageFeignClient {
     @Override
    public PackageResponseDto getById(Long id) {
        throw new PackageServiceUnavailableException("Package service is currently unavailable");
    }
}
