package com.Logistic.LocationService.dto;

import lombok.Data;

@Data
public class LocationRequestDto {

    private String city;
    private String zone;
    private Boolean checkpointAvailable;
}