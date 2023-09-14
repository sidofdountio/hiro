package com.hiro.service.interfaceService;

import com.hiro.model.Question;

import java.util.List;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface QuestionServiceInplement {
    Question saveQuestion(Question question);
    Question editeQuestion(Question question);
    List<Question>QUESTION_LIST();
    Boolean deleteQuestion(Long questionId);
}
