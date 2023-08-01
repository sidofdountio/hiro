package com.hiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class Enroll {
    @SequenceGenerator(name = "enroll_sequence",allocationSize = 1,
            sequenceName = "enroll_sequence")
    @GeneratedValue(generator = "enroll_sequence",strategy = SEQUENCE)
    @Id
    private Long id;
    private String name;
    private LocalDate enrollAt;
    private LocalDate enrollEnd;
}
