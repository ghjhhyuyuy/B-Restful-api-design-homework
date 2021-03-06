package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.MyException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by wzw on 2020/9/14.
 */
@RestController
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController() {
        this.groupService = new GroupService();
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> createGroups() throws IOException, ClassNotFoundException {
        return groupService.createGroups();
    }

    @PatchMapping("{id}")
    public Group updateGroupName(@PathVariable int id, String name) throws MyException {
        return groupService.updateGroupName(id,name);
    }
}
