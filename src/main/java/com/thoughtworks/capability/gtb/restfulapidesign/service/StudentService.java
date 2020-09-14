package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.MyException;
import com.thoughtworks.capability.gtb.restfulapidesign.util.StudentUtil;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wzw on 2020/9/13.
 */
public class StudentService {
    public static final List<Student> studentList = new ArrayList<>();
    private final String[] names = {"沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇",
            "杨思雨", "江雨舟", "廖燊", "胡晓", "但杰", "盖迈达", "肖美琦",
            "黄云洁", "齐瑾浩", "刘亮亮", "肖逸凡", "王作文", "郭瑞凌", "李明豪",
            "党泽", "肖伊佐", "贠晨曦", "李康宁", "马庆", "商婕", "余榕",
            "谌哲", "董翔锐", "陈泰宇", "赵允齐", "张柯", "廖文强", "刘轲",
            "廖浚斌", "凌凤仪"};
    public StudentService() {
        StudentUtil.createOriginList(names,studentList);
    }
    public Student addStudent(Student student) {
        student.setId(studentList.get(studentList.size()-1).getId()+1);
        studentList.add(student);
        return student;
    }

    public void deleteStudent(int id) throws MyException {
        try {
            Student theStudent = studentList.stream().filter(student -> student.getId() == id).collect(Collectors.toList()).get(0);
            studentList.remove(theStudent);
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
            return studentList.stream().filter(student -> student.getId() == id).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            throw new MyException("获取学生失败");
        }

    }

    public Student updateStudents(Student student) throws MyException {
        Student studentOld = this.getStudent(student.getId());
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
