package com.hiro.repository;

import com.hiro.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
    @Override
    Optional<Question> findById(Long aLong);
    Optional<Question> findByName(String name);
}
