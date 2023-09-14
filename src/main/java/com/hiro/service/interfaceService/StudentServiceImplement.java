package com.hiro.service.interfaceService;

import com.hiro.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface StudentServiceImplement {
    Student saveStudent(Student student);

    Student editStudent(Student student);

    Boolean deleteStudent(Long studentId);

    List<Student> studentList();

    Student studentById(Long StudentId);

    Optional<Student> findByEmail(String studentEmail);

}
