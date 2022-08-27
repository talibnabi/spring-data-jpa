package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Course;
import com.company.springdatajpa.entity.Guardian;
import com.company.springdatajpa.entity.Student;
import com.company.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        Integer totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println(courses);
        System.out.println(totalPages);
        System.out.println(totalElements);

    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));
        Pageable sortedByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());
        Pageable sortedByTitleAndCreditDescp = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        courses.forEach(System.out::println);
    }

    @Test
    public void printFindByContaining() {
        PageRequest firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("j", firstPageTenRecords).getContent();
        courses.forEach(System.out::println);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Alisa")
                .lastName("Aslan")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(10)
                .teacher(teacher)
                .build();
        Guardian guardian=Guardian.builder()
                .name("Hikmat")
                .mobile("0709842345")
                .email("hikma@gmail.com")
                .build();
        Student student = Student.builder()
                .firstName("Salman")
                .lastName("Abishov")
                .guardian(guardian)
                .emailAddress("salman@gmail.com")
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}