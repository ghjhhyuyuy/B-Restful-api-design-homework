package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by wzw on 2020/9/13.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private int id;
    @NotNull
    private String name;
    private String note;
    @NotNull
    private List<Student> members;
}
