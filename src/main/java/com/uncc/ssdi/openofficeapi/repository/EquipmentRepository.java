package com.uncc.ssdi.openofficeapi.repository;

import com.uncc.ssdi.openofficeapi.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    public List<Equipment> findByName(String itemName);

}
