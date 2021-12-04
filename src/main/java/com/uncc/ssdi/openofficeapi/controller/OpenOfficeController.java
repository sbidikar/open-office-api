package com.uncc.ssdi.openofficeapi.controller;

import com.uncc.ssdi.openofficeapi.entity.Equipment;
import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import com.uncc.ssdi.openofficeapi.model.SearchRequest;
import com.uncc.ssdi.openofficeapi.service.OpenOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
public class OpenOfficeController {

    @Autowired
    OpenOfficeService openOfficeService;

    @GetMapping("/findAll")
    public List<OfficeFloorMap> findAll() {
        return openOfficeService.findAll();
    }

    @PostMapping("/search")
    public List<OfficeFloorMap> search(@RequestBody SearchRequest searchRequest) {
        return openOfficeService.search(searchRequest);
    }

    @PostMapping("/searchForDate")
    public List<OfficeFloorMap> search(@RequestBody Date reserveDate) {
        return openOfficeService.searchForDate(reserveDate);
    }

    @PostMapping("/save")
    public String save(@RequestBody ReservedDesk reservedDesk) {
        return openOfficeService.save(reservedDesk);
    }

    @PostMapping("/rent")
    public String rent(@RequestBody Equipment equipment) {
        return openOfficeService.rent(equipment);
    }
}
