package com.company.springdata.repository;

import com.company.springdata.entity.Bill;
import com.company.springdata.entity.Laboratory;
import com.company.springdata.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BillRepositoryTest {
    private BillRepository billRepository;

    @Test
    private void saveBill() {
        Patient patient=Patient.builder()
                .firstName("Alisa")
                .lastName("Aslan")
                .age(20)
                .disease("cancer")
                .gender("male")
                .email("alisa@gmail.com")
                .build();
        Bill bill=Bill.builder()
                .patient(patient)
                .labCharge(300)
                .doctorCharge(2000)
                .roomCharge(1000)
                .dayCount(3)
                .build();
    }
}