package com.Logistic.LocationService.feign;

import com.Logistic.LocationService.dto.PackageResponseDto;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(

        name = "package-service",

        url = "http://localhost:8080"

)

public interface PackageFeignClient {

    @GetMapping("/api/packages/{id}")

    PackageResponseDto getById(@PathVariable("id") Long id);

}