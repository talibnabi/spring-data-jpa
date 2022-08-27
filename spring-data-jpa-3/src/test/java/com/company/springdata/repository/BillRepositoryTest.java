package com.company.springdata.repository;

import com.company.springdata.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class BillRepositoryTest {
    @Autowired
    private BillRepository billRepository;

    @Test
    public void saveBill() {
        InPatient inPatient = InPatient.builder()
                .dateOfAdm(LocalDateTime.of(2001, 12, 1, 2, 3))
                .dateOfDis(LocalDateTime.of(2002, 12, 1, 2, 3))
                .build();
        OutPatient outPatient = OutPatient.builder()
                .outDate(LocalDateTime.of(2003, 12, 1, 2, 3))
                .build();
        Laboratory laboratory = Laboratory.builder()
                .labDate(LocalDateTime.of(2001, 12, 1, 2, 3))
                .inPatient(inPatient)
                .outPatient(outPatient)
                .build();
        Nurse nurse = Nurse.builder()
                .nurseFirstName("Anjelina")
                .nurseLastName("Jolie")
                .nurseAge(19)
                .nurseMail("anjelina@gmail.com")
                .build();
        Patient patient = Patient.builder()
                .firstName("Alisa")
                .lastName("Aslan")
                .laboratory(laboratory)
                .age(20)
                .disease("cancer")
                .gender("male")
                .email("alisa@gmail.com")
                .nurse(nurse)
                .build();
        Bill bill = Bill.builder()
                .patient(patient)
                .labCharge(300)
                .doctorCharge(2000)
                .roomCharge(1000)
                .dayCount(3)
                .build();
        billRepository.save(bill);
    }
}