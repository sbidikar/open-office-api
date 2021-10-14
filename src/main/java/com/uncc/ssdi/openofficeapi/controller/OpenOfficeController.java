package com.uncc.ssdi.openofficeapi.controller;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import com.uncc.ssdi.openofficeapi.service.OpenOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OpenOfficeController {

    @Autowired
    OpenOfficeService openOfficeService;

    @GetMapping("/getMessage")
    public String getMessage() {
        return "Hello from Open office";
    }

    @GetMapping("/findAll")
    public List<OfficeFloorMap> findAll() {
        return openOfficeService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody ReservedDesk reservedDesk) {
        openOfficeService.save(reservedDesk);
    }
}
