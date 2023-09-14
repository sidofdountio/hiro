package com.hiro.api;

import com.hiro.model.Student;
import com.hiro.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@RestController
@RequestMapping("api/v1/hiro/admin/student")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> students() {
        return new ResponseEntity<>(studentService.studentList(), OK);
    }
    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody @Validated Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), CREATED);
    }
    @PutMapping("/updateStudent")
    public ResponseEntity<Student> editeStudent(@RequestBody @Validated Student student) {
        return new ResponseEntity<>(studentService.editStudent(student), CREATED);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), OK);
    }




}
