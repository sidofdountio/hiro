package com.hiro.service.interfaceService;

import com.hiro.model.Teacher;

import java.util.List;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface TeacherServiceInplement {
    Teacher  saveTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    List<Teacher> TEACHER_LIST();
    boolean deleteTeacher(Long teacherId);

}
