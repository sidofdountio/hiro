package com.hiro.service;

import com.hiro.model.Question;
import com.hiro.repository.QuestionRepo;
import com.hiro.service.interfaceService.QuestionServiceInplement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Service @Slf4j @RequiredArgsConstructor
public class QuestionService implements QuestionServiceInplement {
    private final QuestionRepo questionRepo;

    /**
     * @param question 
     * @return
     */
    @Override
    public Question saveQuestion(Question question) {
        log.info("add new question {}",question);
        return questionRepo.save(question);
    }

    /**
     * @param question 
     * @return
     */
    @Override
    public Question editeQuestion(Question question) {
        if (!questionRepo.existsById(question.getId())){
            log.error("question with id {} not found",question.getId());
            new  IllegalStateException(String.format("question with id %s not found",question.getId()));
        }
        log.info("updated question {}",question);
        return questionRepo.save(question);
    }

    /**
     * @return 
     */
    @Override
    public List<Question> QUESTION_LIST() {
        log.info("fetching questions");
        return questionRepo.findAll();
    }

    /**
     * @param questionId 
     * @return
     */
    @Override
    public Boolean deleteQuestion(Long questionId) {
        if (!questionRepo.existsById(questionId)){
            log.error("question with id {} not found",questionId);
            new  IllegalStateException(String.format("question with id %s not found",questionId));
            return false;
        }
        log.info("fetching questions");
        questionRepo.deleteById(questionId);
        return true;
    }
}
