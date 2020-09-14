package com.thoughtworks.capability.gtb.restfulapidesign.util;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;

import java.util.List;

/**
 * Created by wzw on 2020/9/14.
 */
public class StudentUtil {
    public static void createOriginList(String[] names,List<Student> studentList) {
        Student student;
        for (int i = 0; i < names.length; i++) {
            student = new Student(i + 1, names[i],null,null);
            studentList.add(student);
        }
    }
}
