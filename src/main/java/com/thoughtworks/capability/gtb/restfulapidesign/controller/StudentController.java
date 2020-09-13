package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by wzw on 2020/9/13.
 */
@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody @Valid Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable int id) throws StudentException {
        studentService.deleteStudent(id);
    }
    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) String gender){
        return studentService.getStudents(gender);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable int id) throws StudentException {
        return studentService.getStudent(id);
    }

    @PutMapping("{id}")
    public Student updateStudents(@PathVariable int id,@Valid Student student) throws StudentException {
        student.setId(id);
        return studentService.updateStudents(student);
    }
}
