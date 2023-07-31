package com.hiro.service;

import com.hiro.model.Course;

import java.util.List;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface CourseService {
    Course save(Course course);
    Course update(Course course);
    Boolean deleteCourse(Long id);
    List<Course> course_list ();
    Course getCourseId(Long id);
}
