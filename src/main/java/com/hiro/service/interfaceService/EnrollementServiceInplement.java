package com.hiro.service.interfaceService;

import com.hiro.model.Enrollement;

import java.util.List;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface EnrollementServiceInplement {
    Enrollement enrolleStudentAndCourse(Enrollement enrollement);
    List<Enrollement> ENROLLEMENT_LIST();

}
