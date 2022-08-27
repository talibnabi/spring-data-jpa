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
}
