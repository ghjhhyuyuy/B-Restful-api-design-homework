package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentException;

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

    public void deleteStudent(int id) throws StudentException {
        try {
            studentList.remove(id);
        } catch (Exception e) {
            throw new StudentException("删除失败");
        }

    }

    public List<Student> getStudents(String gender) {
        if (gender == null) {
            return studentList;
        }
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student getStudent(int id) throws StudentException {
        try {
            return studentList.get(id);
        } catch (Exception e) {
            throw new StudentException("获取学生失败");
        }

    }

    public Student updateStudents(Student student) throws StudentException {
        Student studentOld = studentList.get(student.getId());
        if(student.getName() != null){
            studentOld.setName(student.getName());
        }
        if(student.getGender() != null) {
            studentOld.setGender(student.getGender());
        }
        if(student.getNote() != null){
            studentOld.setNote(student.getNote());
        }
        try {
            studentList.set(student.getId(), studentOld);
        } catch (Exception e) {
            throw new StudentException("更新数据失败");
        }
        return studentOld;
    }
}
