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
public class Answer {
    @SequenceGenerator(name = "sequence_answer_id",allocationSize = 1,sequenceName = "sequence_answer_id")
    @GeneratedValue(generator = "sequence_answer_id",strategy = SEQUENCE)
    @Id
    private Long id;
    @Column(unique = true)@NotNull(message = "The response can't be empty")
    private String response;
    private int point;
    @ManyToOne
    @JoinColumn(name = "question_id",referencedColumnName = "id",nullable = false, foreignKey = @ForeignKey(name = "answer_question"))
    private Question question;
}
