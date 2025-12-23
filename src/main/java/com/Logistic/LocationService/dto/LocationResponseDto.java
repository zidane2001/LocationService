package com.Logistic.LocationService.dto;

import lombok.Data;

@Data
public class LocationResponseDto {

    private String locationId;
    private String city;
    private String zone;
    private Boolean checkpointAvailable;
}