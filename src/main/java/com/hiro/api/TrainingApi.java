package com.hiro.api;

import com.hiro.model.Training;
import com.hiro.service.TrainingService;
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
@RequestMapping("api/v1/hiro/admin/training")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class TrainingApi {
    private final TrainingService trainingService;

    @GetMapping
    public ResponseEntity<List<Training>> trainings() {
        return new ResponseEntity<>(trainingService.TRAINING_LIST(), OK);
    }

    @PostMapping("/addTraining")
    public ResponseEntity<Training> addnewtraining(@RequestBody @Validated Training addNewTraining) {
        return new ResponseEntity<>(trainingService.saveTraining(addNewTraining), CREATED);
    }


}
