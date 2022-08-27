package com.company.springdata.repository;

import com.company.springdata.entity.InPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InPatientRepository extends JpaRepository<InPatient, Long> {
}
