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
@Table(name = "tbl_room")
public class Room {
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
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_type", nullable = false)
    private String roomType;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne(
            mappedBy = "room"
    )
    private InPatient inPatient;
}
