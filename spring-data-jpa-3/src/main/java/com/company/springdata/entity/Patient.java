package com.company.springdata.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(
        name = "tbl_patient",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "patient_email_id_unique_constraint",
                        columnNames = "patient_email_address"
                ),
                @UniqueConstraint(
                        name = "nurse_email_id_unique_constraint",
                        columnNames = "nurse_mail_address"
                )
        }
)
public class Patient {
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "disease", nullable = false)
    private String disease;

    @Column(name = "patient_email_address", nullable = false)
    private String email;

    @Embedded
    private Nurse nurse;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "patient_doctor_mapping",
            joinColumns = @JoinColumn(
                    name = "patient_id",
                    referencedColumnName = "patient_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "doctor_id",
                    referencedColumnName = "doctor_id"
            )
    )
    @JsonbTransient
    private List<Doctor> doctors;

    @OneToOne(
            mappedBy = "patient"
    )
    private Bill bill;

    @ManyToOne(
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
