package com.Logistic.LocationService.controller;

import com.Logistic.LocationService.dto.LocationRequestDto;
import com.Logistic.LocationService.dto.LocationResponseDto;
import com.Logistic.LocationService.dto.PackageResponseDto;
import com.Logistic.LocationService.service.LocationService;
import com.Logistic.LocationService.entity.Location;
import com.Logistic.LocationService.mapper.LocationMapper;
import java.util.List;
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
        return ResponseEntity.ok(locationService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDto> getById(
            @PathVariable String id) {
        Location entity = locationService.getById(id);
        LocationResponseDto responseDto = mapper.toDto(entity);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<LocationResponseDto>> getAll() {
        List<Location> entities = locationService.getAll();
        List<LocationResponseDto> responseDtos = mapper.toDtoList(entities);
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<PackageResponseDto> getPackageInfo(
            @PathVariable Long packageId) {
        return ResponseEntity.ok(locationService.getPackageInfo(packageId));
    }
}