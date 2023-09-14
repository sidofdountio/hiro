package com.hiro.service.interfaceService;

import com.hiro.model.Training;

import java.util.List;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface TrainingServiceInplement {
    Training saveTraining(Training training);
    Training editeTraining(Training training);
    boolean deleteTraining(Long trainingId);
    List<Training>TRAINING_LIST();

}
