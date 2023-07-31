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
public class Teacher {
    @SequenceGenerator(name = "sequence_teache_id",allocationSize = 1,sequenceName = "sequence_teache_id")
    @GeneratedValue(generator = "sequence_enroll_id",strategy = SEQUENCE)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String lastDiplome;
    private String profession;

}