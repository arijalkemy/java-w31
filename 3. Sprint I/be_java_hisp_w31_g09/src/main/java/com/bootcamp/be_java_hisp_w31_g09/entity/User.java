package com.bootcamp.be_java_hisp_w31_g09.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class User {
    private Integer id;
    private String name;
}
