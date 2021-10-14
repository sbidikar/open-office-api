package com.uncc.ssdi.openofficeapi.repository;

import com.uncc.ssdi.openofficeapi.entity.ReservedDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReservedDeskRepository extends JpaRepository<ReservedDesk, Long> {

    public List<ReservedDesk> findByReservedDate(Date reservedDate);

    public List<ReservedDesk> findByUserIdAndReservedDate(String userId, Date reservedDate);

}
