package com.Logistic.LocationService.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    
    private String id;
    @NotBlank (message = "City cannot be blank")
    private String city;
    @NotBlank (message = "Zone cannot be blank")
    private String zone;
    @NotNull  (message = "Checkpoint availability must be specified")
    private Boolean checkpointAvailable;
}