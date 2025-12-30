package com.Logistic.LocationService.core.feign;

import com.Logistic.LocationService.domain.dto.PackageResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
   name = "package-service",
    fallback = PackageFeignClientFallback.class,
    configuration = FeignConfiguration.class
)

public interface PackageFeignClient {
    @GetMapping("/api/packages/feign/{id}")
    PackageResponseDto getById(@PathVariable("id") Long id);
}
