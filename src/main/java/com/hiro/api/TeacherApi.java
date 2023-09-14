package com.hiro.api;

import com.hiro.model.Teacher;
import com.hiro.service.TeacherService;
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
@RequestMapping("api/v1/hiro/admin/teacher")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequiredArgsConstructor
public class TeacherApi {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>>teachers(){
        return new ResponseEntity<>(teacherService.TEACHER_LIST(),OK);
    }
    @PostMapping("/addTeacher")
    public ResponseEntity<Teacher>addNewTeachers(@RequestBody @Validated Teacher teacherToAdd){
        return new ResponseEntity<>(teacherService.saveTeacher(teacherToAdd),CREATED);
    }


}
