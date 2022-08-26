package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Guardian;
import com.company.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.StubNotFoundException;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder()
                .name("Sahib")
                .email("sahib@gmail.com")
                .mobile("0706754331")
                .build();
        Student student = Student.builder()
                .emailAddress("nazmila@gmail.com")
                .firstName("Nazmila")
                .lastName("Nazmi")
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

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> studentList =
                studentRepository.findByGuardianName("Aliisa");
        studentList.forEach(System.out::println);
    }

    @Test
    public void printStudentLastNameNotNull() {
        List<Student> studentList =
                studentRepository.findByLastNameNotNull();
        studentList.forEach(System.out::println);
    }

    @Test
    public void printStudentFirstNameAndLastName() {
        Student student =
                studentRepository.
                        findByFirstNameAndLastName("Talib", "Nabi");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository
                .getStudentByEmailAddress("talibnabii@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddress2() {
        Student student = studentRepository
                .getStudentByEmailAddress("nazmila@gmail.com");
        System.out.println(student);
    }


    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentFirstName = studentRepository
                .getStudentFirstNameByEmailAddress("talibnabii@gmail.com");
        System.out.println(studentFirstName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student =
                studentRepository
                        .getStudentByEmailAddressNative("nazmila@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository
                .getStudentByEmailAddressNativeNamedParam("nazmila@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailAddressNamedParam() {
        int student = studentRepository.updateStudentNameByEmailAddressNamedParam(
                "Nazmila", "nazmila@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailAddress() {
        int student = studentRepository.updateStudentNameByEmailAddress(
                "Nazmilaaaa", "nazmila@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentLastNameByFirstNameParam() {
        int student = studentRepository
                .updateStudentLastNameByFirstNameParam("Sama", "Nazmilaaaa");
        System.out.println(student);
    }

    @Test
    public void updateStudentLastNameByFirstName() {
        int student = studentRepository
                .updateStudentLastNameByFirstName("Sama", "Nazmilaaaa");
        System.out.println(student);
    }
}