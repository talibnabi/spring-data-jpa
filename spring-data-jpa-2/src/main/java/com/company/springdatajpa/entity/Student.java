package com.company.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "email_id_unique_constraint",
                columnNames = "student_email_address"
        )
)
public class Student {
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long student_id;

    @Column(name = "student_name", nullable = false)
    private String firstName;

    @Column(name = "student_surname", nullable = false)
    private String lastName;

    @Column(name = "student_email_address", nullable = false)
    private String emailAddress;

    @Embedded
    private Guardian guardian;
}
