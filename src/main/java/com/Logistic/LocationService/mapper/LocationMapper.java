package com.Logistic.LocationService.mapper;

import com.Logistic.LocationService.dto.LocationRequestDto;
import com.Logistic.LocationService.dto.LocationResponseDto;
import com.Logistic.LocationService.entity.Location;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location toEntity(LocationRequestDto dto);

    LocationResponseDto toDto(Location entity);

    List<LocationResponseDto> toDtoList(List<Location> entities);
}