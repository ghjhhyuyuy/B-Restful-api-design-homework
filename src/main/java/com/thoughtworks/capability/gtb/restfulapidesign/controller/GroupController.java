package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wzw on 2020/9/14.
 */
@RestController
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PutMapping
    public List<Group> updateGroups() {
        return null;
    }

    @PatchMapping("{id}")
    public Group updateGroupName(@PathVariable int id) {
        return null;
    }
}
