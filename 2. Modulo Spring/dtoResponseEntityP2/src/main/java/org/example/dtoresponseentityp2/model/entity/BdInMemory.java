package org.example.dtoresponseentityp2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BdInMemory {
    List<Person> person ;
    List<Symptom> Symptom ;
}
