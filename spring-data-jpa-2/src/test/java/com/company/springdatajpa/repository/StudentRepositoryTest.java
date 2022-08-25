package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("talibnabi@gmail.com")
                .firstName("Talib")
                .lastName("Nabi")
                .guardianName("Alisa")
                .guardianEmail("alisaasln@gmail.com")
                .guardianMobile("0709533113")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        studentList.forEach(System.out::println);
    }
}