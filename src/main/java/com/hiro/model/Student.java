package com.hiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor @Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email",name = "UQ_email"))
public class Student {
    @SequenceGenerator(name = "sequence_Student_id",allocationSize = 1,sequenceName = "sequence_Student_id")
    @GeneratedValue(generator = "sequence_Student_id",strategy = SEQUENCE)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true) @NotNull(message = "student email can't be empty")
    private String email;
    @OneToMany(mappedBy = "student",cascade = ALL,fetch = EAGER) @JsonIgnore
    private List<Enrollement> enrollements=new ArrayList<>();
}
