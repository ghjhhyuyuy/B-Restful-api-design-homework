package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;

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
}
