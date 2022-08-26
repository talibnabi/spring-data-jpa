package com.company.springdatajpa.repository;

import com.company.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
            value = "select * from tbl_student s where s.student_email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    @Query(
            value = "select * from tbl_student s where s.student_email_address= :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set student_name= ?1 where student_email_address= ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailAddress(String firstName, String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set student_name= :first_name where student_email_address= :emailId",
            nativeQuery = true
    )
    int updateStudentNameByEmailAddressNamedParam(@Param("first_name") String firstName,@Param("emailId") String emailId);
}
