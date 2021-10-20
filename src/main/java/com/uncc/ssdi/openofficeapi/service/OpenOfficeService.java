package com.uncc.ssdi.openofficeapi.service;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import com.uncc.ssdi.openofficeapi.model.SearchRequest;
import com.uncc.ssdi.openofficeapi.repository.OfficeFloorMapRepository;
import com.uncc.ssdi.openofficeapi.repository.ReservedDeskRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;

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
        List<OfficeFloorMap> filteredOfficeFloorMap = officeFloorMaps.stream()
                .filter(a -> null != searchRequest.getBuilding() ? searchRequest.getBuilding().equals(a.getBuilding()): true)
                .filter(a -> null != searchRequest.getFloor() ? searchRequest.getFloor().equals(a.getFloor()): true)
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(reservedDesks)) {
            reservedDesks.forEach(r -> {
                filteredOfficeFloorMap.removeIf(o -> o.getId() == r.getFloorMapId());
            });
        }
        return filteredOfficeFloorMap;
    }

    public String save(ReservedDesk reservedDesk) {
        List<ReservedDesk> reservedDesks = reservedDeskRepository.findAll();
        if(reservedDesks.isEmpty()) {
            reservedDeskRepository.save(reservedDesk);
            return "Desk reserved successfully!";
        } else {
            Iterator<ReservedDesk> iterator = reservedDesks.iterator();
            while(iterator.hasNext()) {
                if(iterator.next().getFloorMapId().equals(reservedDesk.getFloorMapId()) && iterator.next().getReservedDate().equals(reservedDesk.getReservedDate())) {
                    return "Error: desk already reserved.";
                } else {
                    reservedDeskRepository.save(reservedDesk);
                    return "Desk reserved successfully!";
                }
            }
        }
        return "Error: invalid desk reservation.";
    }

}
