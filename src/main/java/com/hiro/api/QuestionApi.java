package com.hiro.api;

import com.hiro.model.Question;
import com.hiro.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @Author sidof
 * @Since 02/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@RestController
@RequestMapping("api/v1/hiro/admin/question")
@CrossOrigin(origins = "http://localhost:4200", originPatterns = "http://localhost:9000", maxAge = 3600)
@RequiredArgsConstructor
public class QuestionApi {
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>>questions(){
        return new ResponseEntity<>(questionService.QUESTION_LIST(),OK);
    }
    @PostMapping("/addQuestion")
    public ResponseEntity<Question>addNewQuestion(@RequestBody @Validated Question question){
        return new ResponseEntity<>(questionService.saveQuestion(question),CREATED);
    }
}
