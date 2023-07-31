package com.hiro.api;

import com.hiro.model.Course;
import com.hiro.service.CourseServiceInplemen;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * @Author sidof
 * @Since 31/07/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@RestController
@RequestMapping("api/v1/hiro/admin/course")
@CrossOrigin(origins = "http://localhost:4200",originPatterns = "http://localhost:9000",maxAge = 3600)
@RequiredArgsConstructor
public class CourseApi {
    private final CourseServiceInplemen courseServiceInplemen;

    @GetMapping
    public ResponseEntity<List<Course>>courseList(){
        return new ResponseEntity<>(courseServiceInplemen.course_list(), OK);
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Course>AddCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseServiceInplemen.save(course), CREATED);
    }

    @PutMapping("/updateCourse")
    public ResponseEntity<Course>editeCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseServiceInplemen.update(course), CREATED);
    }

    @DeleteMapping( "/deleteCourse/{id}")
    public ResponseEntity<Boolean>DeleteCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseServiceInplemen.deleteCourse(id), OK);
    }

    @GetMapping( "/id/{id}")
    public ResponseEntity<Course>courseById(@PathVariable Long id){
        return new ResponseEntity<>(courseServiceInplemen.getCourseId(id), OK);
    }


}
