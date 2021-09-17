package com.uncc.ssdi.openofficeapi.repository;

import com.uncc.ssdi.openofficeapi.entity.OfficeFloorMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeFloorMapRepository extends JpaRepository<OfficeFloorMap, Long> {
    List<OfficeFloorMap> findByLocation(String location);
}
