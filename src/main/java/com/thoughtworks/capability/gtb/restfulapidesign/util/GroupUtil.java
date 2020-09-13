package com.thoughtworks.capability.gtb.restfulapidesign.util;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;

import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by wzw on 2020/9/14.
 */
public class GroupUtil {
    public static List<Student> deepCopy(List<Student> studentList) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(studentList);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteArrayInputStream);
        return (List<Student>) in.readObject();
    }
    public static void randomlySortedList(List<Student> studentList) {
        Collections.shuffle(studentList);
    }
    public static void keepGroupNameGetNewGroup(List<Group> groupList,List<Student> newStudentList,int moreInLine,int numberOfLine) {
        int index = 0;
        for (int i = 0; i < moreInLine; i++) {
            List<Student> groupStudents = newStudentList.subList(index, index + numberOfLine + 1);
            groupList.get(i).setMembers(groupStudents);
            index += numberOfLine + 1;
        }
        for (int i = 0; i < 6 - moreInLine; i++) {
            List<Student> groupStudents = newStudentList.subList(index, index + numberOfLine);
            groupList.get(i + moreInLine).setMembers(groupStudents);
            index += numberOfLine;
        }
    }

    public static void createNewGroup(List<Group> groupList,List<Student> newStudentList,int moreInLine,int numberOfLine) {
        int index = 0;
        for (int i = 0; i < moreInLine; i++) {
            List<Student> groupStudents = newStudentList.subList(index, index + numberOfLine + 1);
            Group group = new Group(i,"Team " + (i + 1),null, groupStudents);
            index += numberOfLine + 1;
            groupList.add(group);
        }
        for (int i = 0; i < 6 - moreInLine; i++) {
            List<Student> groupStudents = newStudentList.subList(index, index + numberOfLine);
            Group group = new Group(i + moreInLine,"Team " + (i + moreInLine + 1),null, groupStudents);
            index += numberOfLine;
            groupList.add(group);
        }
    }
}
