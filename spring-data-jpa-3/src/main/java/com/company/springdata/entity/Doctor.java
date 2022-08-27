package com.company.springdata.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
        name = "tbl_doctor",
        uniqueConstraints = @UniqueConstraint(
                name = "email_id_unique_constraint",
                columnNames = "doctor_email_address"
        )
)
public class Doctor {
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    private Long doctorId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String address;
    @Column(name = "doctor_email_address")
    private String email;
}
