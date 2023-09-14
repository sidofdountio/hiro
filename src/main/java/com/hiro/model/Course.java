package com.hiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

/**
 * @Author sidof
 * @Since 28/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */

@Data @Builder @NoArgsConstructor @AllArgsConstructor @Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_course_name",columnNames = "name"))
public class Course {
    @SequenceGenerator(name = "sequence_course_id",allocationSize = 1,sequenceName = "sequence_course_id")
    @GeneratedValue(generator = "sequence_course_id",strategy = SEQUENCE)
    @Id
    private Long id;
    @Column(unique = true) @NotNull(message = "Course name can't be empty")
    private String name;
    private String description;
    private String videoUrl;
    private String type;
    @OneToMany(mappedBy = "course",cascade = ALL,fetch = EAGER) @JsonIgnore
    private List<Training>trainings=new ArrayList<>();

}
