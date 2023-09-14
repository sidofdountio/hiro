package com.hiro.service.interfaceService;

import com.hiro.model.Answer;

import java.util.List;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface AnswerServiceInplement {
    Answer saveAnswer(Answer answer);
    Answer editeAnswer(Answer answer);
    List<Answer> ANSWER_LIST();
    Boolean deleteAnswer(Long answerId);
}
