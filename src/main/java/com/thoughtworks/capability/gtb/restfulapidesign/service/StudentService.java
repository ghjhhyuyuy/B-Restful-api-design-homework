package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.MyException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wzw on 2020/9/13.
 */
public class StudentService {
    public static final List<Student> studentList = new ArrayList<>();

    public Student addStudent(Student student) {
        student.setId(studentList.size());
        studentList.add(student);
        return student;
    }

    public void deleteStudent(int id) throws MyException {
        try {
            studentList.remove(id);
        } catch (Exception e) {
            throw new MyException("删除失败");
        }

    }

    public List<Student> getStudents(String gender) {
        if (gender == null) {
            return studentList;
        }
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student getStudent(int id) throws MyException {
        try {
            return studentList.get(id);
        } catch (Exception e) {
            throw new MyException("获取学生失败");
        }

    }

    public Student updateStudents(Student student) throws MyException {
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
            throw new MyException("更新数据失败");
        }
        return studentOld;
    }
}
