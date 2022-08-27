package com.company.springdata.repository;

import com.company.springdata.entity.OutPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutPatientRepository extends JpaRepository<OutPatient, Long> {
}
