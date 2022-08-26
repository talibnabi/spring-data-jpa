package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Course;
import com.company.springdatajpa.entity.CourseMaterial;
import com.company.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course course =Course.builder()
                .title(".NET")
                .credit(6)
                .build();
        Teacher teacher= Teacher.builder()
                .firstName("Alisa")
                .lastName("Aslan")
                .courses(List.of(course))
                .build();
        teacherRepository.save(teacher);;
    }
}