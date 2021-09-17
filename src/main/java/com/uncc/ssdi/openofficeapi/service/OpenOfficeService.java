package com.uncc.ssdi.openofficeapi.service;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.repository.OfficeFloorMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenOfficeService {

    private OfficeFloorMapRepository officeFloorMapRepository;

    public OpenOfficeService(@Autowired OfficeFloorMapRepository officeFloorMapRepository) {
        this.officeFloorMapRepository = officeFloorMapRepository;
    }

    public List<OfficeFloorMap> findByLocation(String location){
        return officeFloorMapRepository.findByLocation(location);
    }

    public List<OfficeFloorMap> findAll(){
        return officeFloorMapRepository.findAll();
    }
}
