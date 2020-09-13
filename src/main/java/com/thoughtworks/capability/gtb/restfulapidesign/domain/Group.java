package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by wzw on 2020/9/13.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    int id;
    @NotNull
    String name;
    String note;
}
