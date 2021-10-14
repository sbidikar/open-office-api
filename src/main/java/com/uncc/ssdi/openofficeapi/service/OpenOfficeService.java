package com.uncc.ssdi.openofficeapi.service;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import com.uncc.ssdi.openofficeapi.model.SearchRequest;
import com.uncc.ssdi.openofficeapi.repository.OfficeFloorMapRepository;
import com.uncc.ssdi.openofficeapi.repository.ReservedDeskRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenOfficeService {

    private OfficeFloorMapRepository officeFloorMapRepository;

    private ReservedDeskRepository reservedDeskRepository;

    @Autowired
    public OpenOfficeService(OfficeFloorMapRepository officeFloorMapRepository, ReservedDeskRepository reservedDeskRepository) {
        this.officeFloorMapRepository = officeFloorMapRepository;
        this.reservedDeskRepository = reservedDeskRepository;
    }

    public List<OfficeFloorMap> findAll() {
        return officeFloorMapRepository.findAll();
    }

    public List<OfficeFloorMap> search(SearchRequest searchRequest) {
        List<ReservedDesk> reservedDesks = reservedDeskRepository.findByReservedDate(searchRequest.getReserveDate());
        List<OfficeFloorMap> officeFloorMaps = findAll();
        if(CollectionUtils.isNotEmpty(reservedDesks)){
            reservedDesks.forEach(r ->{
                officeFloorMaps.removeIf(o -> o.getId() == r.getFloorMapId());
            });
        }
        return officeFloorMaps;
    }

    public void save(ReservedDesk reservedDesk) {
        reservedDeskRepository.save(reservedDesk);
    }
}
