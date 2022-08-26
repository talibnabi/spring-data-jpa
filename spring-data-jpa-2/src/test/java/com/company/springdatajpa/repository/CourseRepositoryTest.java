package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Course;
import com.company.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        List<Course> courses = courseRepository.findAll();
        courses.forEach(System.out::println);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher=Teacher.builder()
                .firstName("Talib")
                .lastName("Nabi")
                .build();
        Course course=Course.builder()
                .title("python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}