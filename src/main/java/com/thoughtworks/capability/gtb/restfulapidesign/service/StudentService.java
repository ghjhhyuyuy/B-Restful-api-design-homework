package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzw on 2020/9/13.
 */
public class StudentService {
    private final List<Student> studentList = new ArrayList<>();
    public Student addStudent(Student student) {
        studentList.add(student);
        return student;
    }
}
