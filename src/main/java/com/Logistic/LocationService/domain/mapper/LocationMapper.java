package com.Logistic.LocationService.domain.mapper;

import com.Logistic.LocationService.domain.dto.LocationRequestDto;
import com.Logistic.LocationService.domain.dto.LocationResponseDto;
import com.Logistic.LocationService.domain.entity.Location;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "id", ignore = true)
    Location toEntity(LocationRequestDto dto);

    LocationResponseDto toDto(Location entity);

    List<LocationResponseDto> toDtoList(List<Location> entities);
}