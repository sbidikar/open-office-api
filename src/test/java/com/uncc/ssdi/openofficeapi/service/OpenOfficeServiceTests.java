package com.uncc.ssdi.openofficeapi.service;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import com.uncc.ssdi.openofficeapi.model.SearchRequest;
import com.uncc.ssdi.openofficeapi.model.UserDetail;
import com.uncc.ssdi.openofficeapi.repository.OfficeFloorMapRepository;
import com.uncc.ssdi.openofficeapi.repository.ReservedDeskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpenOfficeServiceTests {

    @Mock
    OfficeFloorMapRepository officeFloorMapRepository;
    @Mock
    ReservedDeskRepository reservedDeskRepository;

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
    public void testSave() {
        ReservedDesk testRD = new ReservedDesk();
        String saveOutput = openOfficeService.save(testRD);
        assertEquals(saveOutput,"Desk reserved successfully!");
    }

    @Test
    public void testSearch() {
        OfficeFloorMap officeFloorMap = new OfficeFloorMap();
        officeFloorMap.setId(new Long(1));
        officeFloorMap.setLocation("Test Location");
        officeFloorMap.setBuilding("Test Building");
        officeFloorMap.setFloor("Test Floor");
        officeFloorMap.setDesk("Test Desk");
        List<OfficeFloorMap> officeFloorMapsMock = new ArrayList<>();
        officeFloorMapsMock.add(officeFloorMap);
        when(officeFloorMapRepository.findAll()).thenReturn(officeFloorMapsMock);
        SearchRequest testSR = new SearchRequest();
        testSR.setBuilding("Test Building");
        testSR.setFloor("Test Floor");
        Date date = Date.valueOf("2021-10-13");
        testSR.setReserveDate(date);
        List<OfficeFloorMap> searchOutput = openOfficeService.search(testSR);
        OfficeFloorMap result = searchOutput.get(0);
        assertEquals(result.getBuilding(), testSR.getBuilding());
    }
}
