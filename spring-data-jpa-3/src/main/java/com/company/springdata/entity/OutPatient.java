package com.company.springdata.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "out_patient")
public class OutPatient {
    @SequenceGenerator(
            name = "out_patient_sequence",
            sequenceName = "out_patient_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "out_patient_sequence"
    )
    @Column(name = "out_patient_id")
    private Long outPatientId;

    @Column(name = "out_date", nullable = false)
    private LocalDateTime outDate;

}
