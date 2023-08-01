package com.hiro.model;

import jakarta.persistence.*;
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
@Data @NoArgsConstructor @AllArgsConstructor @Entity @Table
public class Teacher {
    @SequenceGenerator(name = "teacher_sequence", allocationSize = 1,
            sequenceName = "teacher_sequence")
    @GeneratedValue(generator = "teacher_sequence",strategy = SEQUENCE)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String lastDiplome;
    private String profession;

}
