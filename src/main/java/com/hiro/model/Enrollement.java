package com.hiro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data @NoArgsConstructor @AllArgsConstructor @Entity @Table
public class Enrollement {
    @SequenceGenerator(name = "enrollement_sequence",allocationSize = 1,
            sequenceName = "enrollement_sequence")
    @GeneratedValue(generator = "enrollement_sequence",strategy = SEQUENCE)
    @Id
    private Long id;
    @NotNull
    private LocalDate enrollAt;
    private LocalDate enrollEnd;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "enrollement_student"))
    private Student student;
    @ManyToOne @JoinColumn(name = "traning_id",referencedColumnName = "id",nullable = false, foreignKey = @ForeignKey(name = "enrollement_traning"))
    private Training training;
}
