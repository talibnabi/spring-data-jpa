package com.company.springdata.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "nurseFirstName",
                column = @Column(name = "nurse_first_name", nullable = false)
        ),
        @AttributeOverride(
                name = "nurseLastName",
                column = @Column(name = "nurse_last_name", nullable = false)
        ),
        @AttributeOverride(
                name = "nurseAge",
                column = @Column(name = "nurse_age", nullable = false)
        ),
        @AttributeOverride(
                name = "nurseMail",
                column = @Column(name = "nurse_mail_address", nullable = false)
        )
})
public class Nurse {
    private String nurseFirstName;
    private String nurseLastName;
    private Integer nurseAge;
    private String nurseMail;
}
