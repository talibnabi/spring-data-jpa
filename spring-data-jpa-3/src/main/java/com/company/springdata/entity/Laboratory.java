package com.company.springdata.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tbl_laboratory")
public class Laboratory {
    @SequenceGenerator(
            name = "laboratory_sequence",
            sequenceName = "laboratory_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "laboratory_sequence"
    )
    @Column(name = "laboratory_id")
    private Long laboratoryId;

    @Column(name = "lab_date", nullable = false)
    private LocalDateTime labDate;

    @OneToOne(
            mappedBy = "laboratory"
    )
    private InPatient inPatient;

    @OneToOne(
            mappedBy = "laboratory"
    )
    private OutPatient outPatient;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "laboratory_doctor_mapping",
            joinColumns = @JoinColumn(
                    name = "laboratory_id",
                    referencedColumnName = "laboratory_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "doctor_id",
                    referencedColumnName = "doctor_id"
            )
    )
    private List<Doctor> doctors;


//    @OneToMany(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(
//            name = "laboratory_id",
//            referencedColumnName = "laboratoryId"
//    )
//    private List<Patient> patients;
}
