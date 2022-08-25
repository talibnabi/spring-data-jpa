package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //TODO: JPQL
    @Query("select  s from Student s where s.emailAddress=?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student  s where s.emailAddress=?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //TODO: Native query
    @Query(
            value = "select * from tbl_student s where s.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);
}
