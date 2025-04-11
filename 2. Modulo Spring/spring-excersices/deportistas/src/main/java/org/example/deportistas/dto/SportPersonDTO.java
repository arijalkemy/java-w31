package org.example.deportistas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportPersonDTO {
    private String name;
    private String lastName;
    private String sportName;
}
