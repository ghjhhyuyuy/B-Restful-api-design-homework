package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Created by wzw on 2020/9/13.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    int id;
    @NotNull
    String name;
    String gender;
    String note;
}
