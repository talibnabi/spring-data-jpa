package com.company.springdata.repository;

import com.company.springdata.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class BillRepositoryTest {
    @Autowired
    private BillRepository billRepository;

    @Test
    public void saveBill() {

        Laboratory laboratory = Laboratory.builder()
                .labDate(LocalDateTime.of(2001, 12, 1, 2, 3))
                .build();
        Nurse nurse = Nurse.builder()
                .nurseFirstName("Nariman")
                .nurseLastName("Salman")
                .nurseAge(19)
                .nurseMail("nariman@gmail.com")
                .build();
        Doctor doctor = Doctor.builder()
                .firstName("Narmin")
                .lastName("Narmin")
                .age(19)
                .address("Baku")
                .gender("male")
                .email("narminnarmin@gmail.com")
                .build();
        Patient patient = Patient.builder()
                .firstName("Anar")
                .lastName("Salim")
                .doctors(List.of(doctor))
                .laboratory(laboratory)
                .age(19)
                .disease("cancer")
                .gender("male")
                .email("anar@gmail.com")
                .nurse(nurse)
                .build();
        Bill bill = Bill.builder()
                .patient(patient)
                .labCharge(500)
                .doctorCharge(4000)
                .roomCharge(2500)
                .dayCount(9)
                .build();
        billRepository.save(bill);
    }

    @Test
    public void getBillByDayCountAndDoctorCharge() {
        List<Bill> bill1 = billRepository.getBillByDayCountAndDoctorCharge(9, 4000);
        bill1.forEach(System.out::println);
    }

    @Test
    public void getBillByBillIdAndRoomCharge() {
        Bill bill=billRepository.getBillByBillIdAndRoomCharge(10,2500);
        System.out.println(bill);
    }


}
