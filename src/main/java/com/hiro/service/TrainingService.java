package com.hiro.service;

import com.hiro.model.Training;
import com.hiro.repository.TrainingRepo;
import com.hiro.service.interfaceService.TrainingServiceInplement;
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
@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingService implements TrainingServiceInplement {
    private final TrainingRepo trainingRepo;
    @Override
    public Training saveTraining(Training training) {
        if (training.getNumberOfHour() < 1) {
            throw new IllegalStateException(String.format("training  hour cant not be %d", training.getNumberOfHour()));
        }
        log.info("Add new traing {}", training);
        return trainingRepo.save(training);
    }
    @Override
    public Training editeTraining(Training training) {
        if (trainingRepo.existsById(training.getId())) {
            log.error("training id {} not found", training.getId());
            throw new IllegalStateException(String.format("training id {} not found", training.getId()));
        }
        log.info("update training {}", training);
        return trainingRepo.save(training);
    }
    @Override
    public boolean deleteTraining(Long trainingId) {
        return false;
    }
    @Override
    public List<Training> TRAINING_LIST() {
        log.info("fetching training list ");
        return trainingRepo.findAll();
    }
}
