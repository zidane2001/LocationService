package com.Logistic.LocationService.domain.controller;

import com.Logistic.LocationService.domain.dto.LocationRequestDto;
import com.Logistic.LocationService.domain.dto.LocationResponseDto;
import com.Logistic.LocationService.domain.dto.PackageResponseDto;
import com.Logistic.LocationService.domain.service.LocationService;
import com.Logistic.LocationService.domain.entity.Location;
import com.Logistic.LocationService.domain.mapper.LocationMapper;
import java.util.List;

import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final LocationMapper mapper;

    @PostMapping
    public ResponseEntity<LocationResponseDto> create(
            @RequestBody LocationRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(locationService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDto> getById(@PathVariable String id) {
        Location entity = locationService.getById(id);
        LocationResponseDto responseDto = mapper.toDto(entity);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LocationResponseDto>> getAll() {
        List<LocationResponseDto> responseDtos = locationService.getAll();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<PackageResponseDto> getPackageInfo(@PathVariable Long packageId) {
        return ResponseEntity.ok(locationService.getPackageInfo(packageId));
    }
}