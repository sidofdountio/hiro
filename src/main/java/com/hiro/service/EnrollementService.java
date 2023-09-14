package com.hiro.service;

import com.hiro.model.Enrollement;
import com.hiro.repository.EnrollementRepo;
import com.hiro.service.interfaceService.EnrollementServiceInplement;
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
public class EnrollementService implements EnrollementServiceInplement {
    private final EnrollementRepo enrollementRepo;
    /**
     * @param enrollement 
     * @return
     */
    @Override
    public Enrollement enrolleStudentAndCourse(Enrollement enrollement) {
//       TODO: if(enrollement.getStudent().getId() == null )
        log.info("Add new enrollement {} ",enrollement);
        return enrollementRepo.save(enrollement);
    }

    /**
     * @return 
     */
    @Override
    public List<Enrollement> ENROLLEMENT_LIST() {
        log.info("Fetching enrollement");
        return enrollementRepo.findAll();
    }
}
