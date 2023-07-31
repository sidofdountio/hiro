package com.hiro.repository;

import com.hiro.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Optional<Course> findByName(String name);
}
