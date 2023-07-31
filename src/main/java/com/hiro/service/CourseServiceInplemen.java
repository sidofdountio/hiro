package com.hiro.service;

import com.hiro.model.Course;
import com.hiro.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Boolean.TRUE;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CourseServiceInplemen implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        log.info("Saving new course {}", course);
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        if (course.getName() == null) {
            log.error("course name can't be empty");
            throw new NullPointerException(String.format("course name can't be empty"));
        }
        if (course.getDescription() == null) {
            log.error("course description can't be empty");
            throw new NullPointerException(String.format("course description can't be empty"));
        }
        if (course.getVideoUrl() == null) {
            log.error("course video url can't be empty");
            throw new NullPointerException(String.format("course video url can't be empty"));
        }
        log.info("Updating course {}", course);
        return courseRepository.save(course);
    }

    @Override
    public Boolean deleteCourse(Long id) {
        boolean existsById = courseRepository.existsById(id);
        if (!existsById) {
            new NullPointerException(String.format("Course id: %s not found "));
        }
        courseRepository.deleteById(id);
        return TRUE;
    }

    @Override
    public List<Course> course_list() {
        log.info("Fetching course");
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseId(Long id) {
        return courseRepository.findById(id).orElseThrow(()-> new NullPointerException(String.format("Course id: %s not found",id)));
    }
}
