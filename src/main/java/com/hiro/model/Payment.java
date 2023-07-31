package com.hiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
public class Payment {
    @SequenceGenerator(name = "sequence_answer_id",allocationSize = 1,sequenceName = "sequence_answer_id")
    @GeneratedValue(generator = "sequence_answer_id",strategy = SEQUENCE)
    @Id
    private Long id;
    private double amount;
    private String transactionId;

}
