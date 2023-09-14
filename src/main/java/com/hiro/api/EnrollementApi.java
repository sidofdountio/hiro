package com.hiro.api;

import com.hiro.model.Enrollement;
import com.hiro.service.EnrollementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.time.LocalDate.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @Author sidof
 * @Since 02/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@RestController
@RequestMapping("api/v1/hiro/admin/enrollement")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class EnrollementApi {
    private final EnrollementService enrollementService;

    @GetMapping
    public ResponseEntity<List<Enrollement>> enrolements() {
        return new ResponseEntity<>(enrollementService.ENROLLEMENT_LIST(), OK);
    }
    @PostMapping("/enrolleStudentAndTraining")
    public ResponseEntity<Enrollement> enrolleStudentAndTraining(@RequestBody @Validated Enrollement enrolleStudentAndTraining) {
        enrolleStudentAndTraining.setEnrollAt(now());
        return new ResponseEntity(enrollementService.enrolleStudentAndCourse(enrolleStudentAndTraining), CREATED);
    }
}
