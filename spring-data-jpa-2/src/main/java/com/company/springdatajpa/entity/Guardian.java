package com.company.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name",nullable = false)
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email",nullable = false)
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile_number",nullable = false)
        )
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
