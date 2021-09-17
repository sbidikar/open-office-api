package com.uncc.ssdi.openofficeapi.controller;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.service.OpenOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpenOfficeController {

    @Autowired
    OpenOfficeService openOfficeService;

    @GetMapping("/getMessage")
    public String getMessage(){
        return "Hello from Open office";
    }

    @GetMapping("/findAll")
    public List<OfficeFloorMap> findAll(){
        return openOfficeService.findAll();
    }

    @GetMapping("/findByLocation")
    public List<OfficeFloorMap> findByLocation(String location){
        return openOfficeService.findByLocation(location);
    }
}
