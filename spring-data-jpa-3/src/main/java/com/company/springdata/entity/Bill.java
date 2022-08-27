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
@Table(name = "tbl_bill")
public class Bill {
    @SequenceGenerator(
            name = "bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "doctor_charge", nullable = false)
    private Integer doctorCharge;

    @Column(name = "room_charge", nullable = false)
    private Integer roomCharge;

    @Column(name = "day_count", nullable = false)
    private Integer dayCount;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "patient_id"
    )
    private Patient patient;

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
