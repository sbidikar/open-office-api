package com.uncc.ssdi.openofficeapi.service;

import com.uncc.ssdi.openofficeapi.entity.Equipment;
import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import com.uncc.ssdi.openofficeapi.model.SearchRequest;
import com.uncc.ssdi.openofficeapi.repository.EquipmentRepository;
import com.uncc.ssdi.openofficeapi.repository.OfficeFloorMapRepository;
import com.uncc.ssdi.openofficeapi.repository.ReservedDeskRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpenOfficeService {

    private OfficeFloorMapRepository officeFloorMapRepository;

    private ReservedDeskRepository reservedDeskRepository;

    private EquipmentRepository equipmentRepository;

    @Autowired
    public OpenOfficeService(OfficeFloorMapRepository officeFloorMapRepository, ReservedDeskRepository reservedDeskRepository, EquipmentRepository equipmentRepository) {
        this.officeFloorMapRepository = officeFloorMapRepository;
        this.reservedDeskRepository = reservedDeskRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public List<OfficeFloorMap> findAll() {
        return officeFloorMapRepository.findAll();
    }

    public List<OfficeFloorMap> search(SearchRequest searchRequest) {
        List<ReservedDesk> reservedDesks = reservedDeskRepository.findByReservedDate(searchRequest.getReserveDate());
        List<OfficeFloorMap> officeFloorMaps = findAll();
        List<OfficeFloorMap> filteredOfficeFloorMap = officeFloorMaps.stream()
                .filter(a -> null != searchRequest.getBuilding() ? searchRequest.getBuilding().equals(a.getBuilding()) : true)
                .filter(a -> null != searchRequest.getFloor() ? searchRequest.getFloor().equals(a.getFloor()) : true)
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(reservedDesks)) {
            reservedDesks.forEach(r -> {
                filteredOfficeFloorMap.removeIf(o -> o.getId() == r.getFloorMapId());
            });
        }
        return filteredOfficeFloorMap;
    }

    public List<OfficeFloorMap> searchForDate(Date reserveDate) {
        List<OfficeFloorMap> reservedForDate = new ArrayList<>();
        List<ReservedDesk> reservedDesks = reservedDeskRepository.findByReservedDate(reserveDate);
        List<OfficeFloorMap> officeFloorMaps = findAll();
        if (CollectionUtils.isNotEmpty(reservedDesks)) {
            reservedForDate = officeFloorMaps.stream().filter(ofm -> ofm.getId().equals(reservedDesks.get(0).getFloorMapId())).collect(Collectors.toList());
        }
        return reservedForDate;
    }

    public String save(ReservedDesk reservedDesk) {
        List<ReservedDesk> reservedDesks = reservedDeskRepository.findAll();
        if (reservedDesks.isEmpty()) {
            reservedDeskRepository.save(reservedDesk);
            return "Desk reserved successfully!";
        } else {
            Iterator<ReservedDesk> iterator = reservedDesks.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getFloorMapId().equals(reservedDesk.getFloorMapId()) && iterator.next().getReservedDate().equals(reservedDesk.getReservedDate())) {
                    return "Error: desk already reserved.";
                } else {
                    reservedDeskRepository.save(reservedDesk);
                    return "Desk reserved successfully!";
                }
            }
        }
        return "Error: invalid desk reservation.";
    }

    public String rent(Equipment equipment) {
        List<Equipment> rentedEquipment = equipmentRepository.findAll();

        if (rentedEquipment.isEmpty()) {
            equipmentRepository.save(equipment);
            return "Equipment rented successfully!";
        } else {
            Iterator<Equipment> iterator = rentedEquipment.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getItemId() == equipment.getItemId() && iterator.next().getName().equals(equipment.getName())) {
                    return "Error: equipment already rented.";
                } else {
                    equipmentRepository.save(equipment);
                    return "Equipment rented successfully!";
                }
            }
        }
        return "Error: invalid equipment request.";
    }

}
