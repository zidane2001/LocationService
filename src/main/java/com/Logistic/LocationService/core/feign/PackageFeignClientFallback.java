package com.Logistic.LocationService.core.feign;

import org.springframework.stereotype.Component;
import com.Logistic.LocationService.domain.dto.PackageResponseDto;
import com.Logistic.LocationService.domain.exception.PackageServiceUnavailableException;

@Component
public class PackageFeignClientFallback implements PackageFeignClient {
    @Override
    public PackageResponseDto getPackage(Long id) {
        throw new PackageServiceUnavailableException("Package service is currently unavailable");
    }
}
