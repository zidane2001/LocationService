package com.Logistic.LocationService.feign;

import com.Logistic.LocationService.dto.PackageResponseDto;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "package-service")

public interface PackageFeignClient {

    @GetMapping("/api/packages/feign/{id}")
    PackageResponseDto getById(@PathVariable("id") Long id);
}
