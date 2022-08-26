package com.company.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
                ", course_id=" + course.getCourseId() +
                '}';
    }
}
