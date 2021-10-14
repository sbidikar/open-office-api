package com.uncc.ssdi.openofficeapi.service;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.repository.OfficeFloorMapRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpenOfficeServiceTests {

    @Mock
    OfficeFloorMapRepository officeFloorMapRepository;

    @InjectMocks
    OpenOfficeService openOfficeService;


    @Test
    public void testFindAll() {
        assertNotNull(officeFloorMapRepository);
        OfficeFloorMap officeFloorMap = new OfficeFloorMap();
        officeFloorMap.setId(new Long(1));
        officeFloorMap.setLocation("Test Location");
        officeFloorMap.setBuilding("Test Building");
        officeFloorMap.setFloor("Test Floor");
        officeFloorMap.setDesk("Test Desk");
        List<OfficeFloorMap> officeFloorMapsMock = new ArrayList<>();
        officeFloorMapsMock.add(officeFloorMap);
        when(officeFloorMapRepository.findAll()).thenReturn(officeFloorMapsMock);
        List<OfficeFloorMap> officeFloorMapsResult = openOfficeService.findAll();
        verify(officeFloorMapRepository).findAll();
        assertEquals(officeFloorMapsMock,officeFloorMapsResult);
    }

    @Test
    public void testFindByLocation() {
        assertNotNull(officeFloorMapRepository);
        OfficeFloorMap officeFloorMap = new OfficeFloorMap();
        officeFloorMap.setId(new Long(1));
        officeFloorMap.setLocation("Test Location");
        officeFloorMap.setBuilding("Test Building");
        officeFloorMap.setFloor("Test Floor");
        officeFloorMap.setDesk("Test Desk");
        List<OfficeFloorMap> officeFloorMapsMock = new ArrayList<>();
        officeFloorMapsMock.add(officeFloorMap);
        when(officeFloorMapRepository.findByLocation("Test Location")).thenReturn(officeFloorMapsMock);
        List<OfficeFloorMap> officeFloorMapsResult = openOfficeService.findByLocation("Test Location");
        verify(officeFloorMapRepository).findByLocation("Test Location");
        assertEquals(officeFloorMapsMock,officeFloorMapsResult);
    }
}
