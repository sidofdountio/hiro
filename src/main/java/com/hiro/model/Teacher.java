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
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data @NoArgsConstructor @AllArgsConstructor @Entity @Table(uniqueConstraints = @UniqueConstraint(columnNames = "email",name = "UQ_teacher_email"))
public class Teacher {
    @SequenceGenerator(name = "teacher_sequence", allocationSize = 1,
            sequenceName = "teacher_sequence")
    @GeneratedValue(generator = "teacher_sequence",strategy = SEQUENCE)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @NotNull(message = "Last diplome can't be empty")
    private String lastDiplome;
    private String profession;
    @OneToMany(mappedBy = "teacher",cascade = ALL,fetch = EAGER) @JsonIgnore
    private List<Training>trainingList=new ArrayList<>();

}
