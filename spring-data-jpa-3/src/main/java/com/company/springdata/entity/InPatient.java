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
@Table(name = "tbl_in_patient")
public class InPatient {
    @SequenceGenerator(
            name = "in_patient_sequence",
            sequenceName = "in_patient_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "in_patient_sequence"
    )
    @Column(name = "in_patient_id")
    private Long inPatientId;

    @Column(name = "date_of_adm", nullable = false)
    private LocalDateTime dateOfAdm;

    @Column(name = "date_of_dis", nullable = false)
    private LocalDateTime dateOfDis;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "room_id",
            referencedColumnName = "room_id"
    )
    private Room room;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "laboratory_id",
            referencedColumnName = "laboratory_id"
    )
    private Laboratory laboratory;
}
