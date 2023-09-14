package com.hiro.repository;

import com.hiro.model.Answer;
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
public interface AnswerRepo extends JpaRepository<Answer,Long> {
    Optional<Answer> findByResponse(String name);
}
