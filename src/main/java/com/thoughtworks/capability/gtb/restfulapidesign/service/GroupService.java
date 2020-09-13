package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.MyException;
import com.thoughtworks.capability.gtb.restfulapidesign.util.GroupUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzw on 2020/9/14.
 */
public class GroupService {
    private final List<Group> groupList = new ArrayList<>();
    public List<Group> getGroups() {
        return groupList;
    }

    public List<Group> createGroups() throws IOException, ClassNotFoundException {
        List<Student> studentList = StudentService.studentList;
        List<Student> newStudentList = GroupUtil.deepCopy(studentList);
        GroupUtil.randomlySortedList(newStudentList);
        int numberOfLine = studentList.size() / 6;
        int moreInLine = studentList.size() % 6;
        if (groupList.isEmpty()) {
            GroupUtil.createNewGroup(this.groupList,newStudentList,moreInLine,numberOfLine);
        } else {
            GroupUtil.keepGroupNameGetNewGroup(this.groupList,newStudentList,moreInLine,numberOfLine);
        }
        return groupList;
    }

    public Group updateGroupName(int id, String name) throws MyException {
        try{
            Group group = groupList.get(id);
            group.setName(name);
            groupList.set(id,group);
            return group;
        }catch (Exception e){
            throw new MyException("更新组名失败");
        }


    }
}
