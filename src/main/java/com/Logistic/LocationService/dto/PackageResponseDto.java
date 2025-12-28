package com.Logistic.LocationService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageResponseDto {
    private Long id;
    private String description;
    private Double weight;
    private Boolean isFragile;
    private String status; 
}