package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wzw on 2020/9/13.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    int id;
    String name;
    String gender;
    String note;
}
