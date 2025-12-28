package com.Logistic.LocationService.mapper;

import com.Logistic.LocationService.dto.LocationRequestDto;
import com.Logistic.LocationService.dto.LocationResponseDto;
import com.Logistic.LocationService.entity.Location;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "locationId", ignore = true)
    Location toEntity(LocationRequestDto dto);

    LocationResponseDto toDto(Location entity);

    List<LocationResponseDto> toDtoList(List<Location> entities);
}