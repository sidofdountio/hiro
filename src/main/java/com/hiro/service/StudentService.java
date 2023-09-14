package com.hiro.service;

import com.hiro.model.Student;
import com.hiro.repository.StudentRepo;
import com.hiro.service.interfaceService.StudentServiceImplement;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StudentService implements StudentServiceImplement {
    private final StudentRepo studentRepo;

    /**
     * @param student
     * @return
     */
    @Override
    public Student saveStudent(Student student) {
        Optional<Student> studentByEmail = studentRepo.findByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            log.error("email {} taken", student.getEmail());
            new IllegalStateException(String.format("email %s taken"));
        }
        log.info("Adding new student {}", student);
        return studentRepo.save(student);
    }

    /**
     * @param student
     * @return
     */
    @Override
    public Student editStudent(Student student) {
        Student studentById = studentRepo.findById(student.getId())
                .orElseThrow(() ->
                        new IllegalStateException(String.format("Student with id %s does not exist", student.getId())));
        log.info("Updating student {}",student);
       return  studentRepo.save(student);
    }

    /**
     * @param studentId
     * @return
     */
    @Override
    public Boolean deleteStudent(Long studentId) {
        if (!studentRepo.existsById(studentId)) {
            log.error("student id {} does not exist",studentId);
            return FALSE;
        }
        log.info("student with id {} deleted",studentId);
        studentRepo.deleteById(studentId);
        return TRUE;
    }

    /**
     * @return
     */
    @Override
    public List<Student> studentList() {
        log.info("fetching student");
        return studentRepo.findAll();
    }

    /**
     * @param StudentId
     * @return
     */
    @Override
    public Student studentById(Long StudentId) {
        if (!studentRepo.existsById(StudentId)) {
            log.error("student id {} does not exist",StudentId);
            throw new IllegalStateException(String.format("student id %s does not exist",StudentId));
        }
        log.info("student with id {} found",StudentId);
        return studentRepo.getById(StudentId);
    }

    /**
     * @param studentEmail
     * @return
     */
    @Override
    public Optional<Student> findByEmail(String studentEmail) {
        return Optional.ofNullable(studentRepo.findByEmail(studentEmail)
                .orElseThrow(() -> new IllegalStateException(String.format("student with email %s not found",studentEmail))));
    }
}
