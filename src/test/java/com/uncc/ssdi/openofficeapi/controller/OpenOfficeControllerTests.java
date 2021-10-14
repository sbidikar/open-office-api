package com.uncc.ssdi.openofficeapi.controller;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.service.OpenOfficeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(controllers = OpenOfficeController.class)
public class OpenOfficeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpenOfficeService openOfficeService;

    List<OfficeFloorMap> officeFloorMapsMock;

    @BeforeEach
    void setUp(){
        OfficeFloorMap officeFloorMap = new OfficeFloorMap();
        officeFloorMap.setId(new Long(1));
        officeFloorMap.setLocation("Test Location");
        officeFloorMap.setBuilding("Test Building");
        officeFloorMap.setFloor("Test Floor");
        officeFloorMap.setDesk("Test Desk");
        this.officeFloorMapsMock = new ArrayList<>();
        officeFloorMapsMock.add(officeFloorMap);

    }

    @Test
    void tesFindAll(){

    }
}
