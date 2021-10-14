package com.uncc.ssdi.openofficeapi.service;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import com.uncc.ssdi.openofficeapi.repository.OfficeFloorMapRepository;
import com.uncc.ssdi.openofficeapi.repository.ReservedDeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenOfficeService {

    private OfficeFloorMapRepository officeFloorMapRepository;

    private ReservedDeskRepository reservedDeskRepository;

    public OpenOfficeService(@Autowired OfficeFloorMapRepository officeFloorMapRepository, ReservedDeskRepository reservedDeskRepository) {
        this.officeFloorMapRepository = officeFloorMapRepository;
        this.reservedDeskRepository = reservedDeskRepository;
    }

    public List<OfficeFloorMap> findByLocation(String location){
        return officeFloorMapRepository.findByLocation(location);
    }

    public List<OfficeFloorMap> findAll(){
        return officeFloorMapRepository.findAll();
    }

    public void save(ReservedDesk reservedDesk){
        reservedDeskRepository.save(reservedDesk);
    }
}
