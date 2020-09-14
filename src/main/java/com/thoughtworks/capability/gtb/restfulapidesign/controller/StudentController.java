package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.MyException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wzw on 2020/9/13.
 */
@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(){
        this.studentService = new StudentService();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody @Valid Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable int id) throws MyException {
        studentService.deleteStudent(id);
    }
    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) String gender){
        return studentService.getStudents(gender);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable int id) throws MyException {
        return studentService.getStudent(id);
    }

    @PutMapping("{id}")
    public Student updateStudents(@PathVariable int id,@RequestBody @Valid Student student) throws MyException {
        student.setId(id);
        return studentService.updateStudents(student);
    }
}
