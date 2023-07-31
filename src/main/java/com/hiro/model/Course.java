package com.hiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

/**
 * @Author sidof
 * @Since 28/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */

@Data @Builder @NoArgsConstructor @AllArgsConstructor @Entity
public class Course {
    @SequenceGenerator(name = "sequence_course_id",allocationSize = 1,sequenceName = "sequence_course_id")
    @GeneratedValue(generator = "sequence_course_id",strategy = SEQUENCE)
    @Id
    private Long id;
    private String name;
    private String description;
    private String videoUrl;
    private String type;

}
