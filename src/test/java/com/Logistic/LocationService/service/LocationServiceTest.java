package com.Logistic.LocationService.service;

import com.Logistic.LocationService.core.feign.PackageFeignClient;
import com.Logistic.LocationService.domain.dto.LocationRequestDto;
import com.Logistic.LocationService.domain.dto.LocationResponseDto;
import com.Logistic.LocationService.domain.dto.PackageResponseDto;
import com.Logistic.LocationService.domain.entity.Location;
import com.Logistic.LocationService.domain.exception.LocationNotFoundException;
import com.Logistic.LocationService.domain.mapper.LocationMapper;
import com.Logistic.LocationService.domain.repository.LocationRepository;
import com.Logistic.LocationService.domain.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private LocationRepository repository;
    @Mock
    private LocationMapper mapper;
    @Mock
    private PackageFeignClient packageFeignClient;
    @InjectMocks
    private LocationServiceImpl service;

    private Location location;
    private LocationRequestDto requestDto;
    private LocationResponseDto responseDto;
    private PackageResponseDto packageResponseDto;

    @BeforeEach
    void setUp() {
        location = new Location();
        location.setId("1");
        location.setCity("Test City");
        location.setZone("Test Zone");
        location.setCheckpointAvailable(true);

        requestDto = new LocationRequestDto();
        requestDto.setCity("Test City");
        requestDto.setZone("Test Zone");
        requestDto.setCheckpointAvailable(true);

        responseDto = new LocationResponseDto();
        responseDto.setId("1");
        responseDto.setCity("Test City");
        responseDto.setZone("Test Zone");
        responseDto.setCheckpointAvailable(true);

        packageResponseDto = new PackageResponseDto();
        packageResponseDto.setId(1L);
        packageResponseDto.setDescription("Test Package");
        packageResponseDto.setWeight(5.0);
        packageResponseDto.setIsFragile(true);
        packageResponseDto.setStatus("CREATED");
    }

    @Test
    void create_ShouldReturnLocationResponseDto() {
        when(mapper.toEntity(requestDto)).thenReturn(location);
        when(repository.save(location)).thenReturn(location);
        when(mapper.toDto(location)).thenReturn(responseDto);

        LocationResponseDto result = service.create(requestDto);

        assertNotNull(result);
        assertEquals("1", result.getId());
        verify(repository).save(location);
    }

    @Test
    void getById_ShouldReturnLocation_WhenExists() {
        when(repository.findById("1")).thenReturn(Optional.of(location));
        Location result = service.getById("1");
        assertNotNull(result);
        assertEquals("1", result.getId());
    }

    @Test
    void getById_ShouldThrowException_WhenNotExists() {
        when(repository.findById("1")).thenReturn(Optional.empty());

        assertThrows(LocationNotFoundException.class, () -> service.getById("1"));
    }

    @Test
    void getAll_ShouldReturnListOfLocation() {
        when(repository.findAll()).thenReturn(List.of(location));
        when(mapper.toDto(location)).thenReturn(responseDto);
        List<LocationResponseDto> result = service.getAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void getPackageInfo_ShouldReturnPackageResponseDto() {
        when(packageFeignClient.getById(1L)).thenReturn(packageResponseDto);

        PackageResponseDto result = service.getPackageInfo(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Package", result.getDescription());
        verify(packageFeignClient).getById(1L);
    }

}