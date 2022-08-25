package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Guardian;
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
        Guardian guardian = Guardian.builder()
                .name("Aliisa")
                .email("alisaa@gmail.com")
                .mobile("0706754332")
                .build();
        Student student = Student.builder()
                .emailId("talibnabii@gmail.com")
                .firstName("Talib")
                .lastName("Nabi")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentGuardianDetails() {
        Guardian guardian = Guardian.builder()
                .name("Aliisa")
                .email("alisaa@gmail.com")
                .mobile("0706754332")
                .build();
        Student student = Student.builder()
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        studentList.forEach(System.out::println);
    }

    @Test
    public void printStudentsByFirstName() {
        List<Student> studentList =
                studentRepository.findByFirstName("Talib");
        studentList.forEach(System.out::println);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList =
                studentRepository.findByFirstNameContaining("Ta");
        studentList.forEach(System.out::println);
    }
}