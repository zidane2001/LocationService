package com.Logistic.LocationService.dto;

import lombok.Data;

@Data
public class PackageResponseDto {

    private Long id;
    private String trackingNumber;
    private String status;
}