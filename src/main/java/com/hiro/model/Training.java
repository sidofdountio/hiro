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

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor @Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_traning_name",columnNames = "name"))
public class Training {
    @SequenceGenerator(name = "sequence_training_id",allocationSize = 1,sequenceName = "sequence_training_id")
    @GeneratedValue(generator = "sequence_training_id",strategy = SEQUENCE)
    @Id
    private Long id;
    @Column(unique = true) @NotNull(message = "traning name can't be emty")
    private String name;
    @NotNull(message = "Traning number of hour can't be empty")
    private int numberOfHour;
    @OneToMany(mappedBy = "training",cascade = ALL,fetch = EAGER) @JsonIgnore
    private List<Enrollement>enrollements=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false,foreignKey = @ForeignKey(name = "traning_course"))
    private Course course;
    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id",nullable = false,foreignKey = @ForeignKey(name = "traning_teacher"))
    private Teacher teacher;
}
