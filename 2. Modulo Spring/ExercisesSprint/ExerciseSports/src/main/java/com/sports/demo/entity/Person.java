package com.sports.demo.entity;

import java.util.List;

import com.sports.demo.dto.SportDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
     private List<Sport> sports;
}
