package com.hiro.service;

import com.hiro.model.Teacher;
import com.hiro.repository.TeacherRepo;
import com.hiro.service.interfaceService.TeacherServiceInplement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Service @Slf4j @RequiredArgsConstructor
public class TeacherService implements TeacherServiceInplement {
    private final TeacherRepo teacherRepo;
    /**
     * @param teacher 
     * @return
     */
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepo.findByEmail(teacher.getEmail());
        if (teacherOptional.isPresent()){
            throw new IllegalStateException(String.format( " %s has been taken ",teacher.getEmail()));
        }
        log.info("add new teacher {}",teacher);
        return teacherRepo.save(teacher);
    }

    /**
     * @param teacher
     * @return
     */
    @Override
    public Teacher updateTeacher(Teacher teacher) {
        if (teacherRepo.existsById(teacher.getId())){
            log.error("Teacher with id {} not found",teacher.getId());
            new IllegalStateException(String.format("Teacher with id %s not found",teacher.getId()));
        }
        log.info("edited teacher {}",teacher);
        return teacherRepo.save(teacher);
    }

    /**
     * @return 
     */
    @Override
    public List<Teacher> TEACHER_LIST() {
        log.info("fetching teachers");
        return teacherRepo.findAll();
    }

    /**
     * @param teacherId 
     * @return
     */
    @Override
    public boolean deleteTeacher(Long teacherId) {
        if (!teacherRepo.existsById(teacherId)){
            log.error("Teacher with id {} not found",teacherId);
            new IllegalStateException(String.format("Teacher with id %s not found",teacherId));
            return false;
        }
        log.info("delete teacher with id {}",teacherId);
        teacherRepo.deleteById(teacherId);
        return true;
    }
}
