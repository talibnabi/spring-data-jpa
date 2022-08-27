package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Course;
import com.company.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
        Teacher teacher = Teacher.builder()
                .firstName("Talib")
                .lastName("Nabi")
                .build();
        Course course = Course.builder()
                .title("c++")
//                .teacher(teacher)
                .credit(6)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        Integer totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println(courses);
        System.out.println(totalPages);
        System.out.println(totalElements);

    }
}