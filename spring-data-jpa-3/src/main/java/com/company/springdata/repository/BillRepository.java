package com.company.springdata.repository;

import com.company.springdata.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByDayCount(Integer dayCount);

}
