package com.Logistic.LocationService.domain.dto;

import lombok.Data;

@Data
public class LocationResponseDto {

    private String id;
    private String city;
    private String zone;
    private Boolean checkpointAvailable;
}