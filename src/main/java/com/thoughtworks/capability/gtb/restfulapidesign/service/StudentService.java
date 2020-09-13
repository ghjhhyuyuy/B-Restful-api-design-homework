package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wzw on 2020/9/13.
 */
public class StudentService {
    private final List<Student> studentList = new ArrayList<>();
    public Student addStudent(Student student) {
        student.setId(studentList.size());
        studentList.add(student);
        return student;
    }

    public void deleteStudent(int id) {
        studentList.remove(id);
    }

    public List<Student> getStudents(String gender) {
        if(gender == null) {
            return studentList;
        }
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }
}
