package com.hiro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor @Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UQ_question_name",columnNames = "name"))
public class Question {
    @SequenceGenerator(name = "sequence_question_id",allocationSize = 1,sequenceName = "sequence_question_id")
    @GeneratedValue(generator = "sequence_question_id",strategy = SEQUENCE)
    @Id
    private Long id;
    @Column(unique = true) @NotNull(message = "Question name can't be empty")
    private String name;
    private int numberOfTime;
    @ManyToOne @JoinColumn(name = "traning_id",referencedColumnName = "id",nullable = false, foreignKey = @ForeignKey(name = "question_traning"))
    private Training training;

}
