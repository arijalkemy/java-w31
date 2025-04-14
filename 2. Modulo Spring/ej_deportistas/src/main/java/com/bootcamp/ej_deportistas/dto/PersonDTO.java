package com.bootcamp.ej_deportistas.dto;

import java.util.List;
public class PersonDTO {
        private String name;
        private String surname;
        private List<String> sports;

        public PersonDTO(String name, String surname, List<String> sports) {
            this.name = name;
            this.surname = surname;
            this.sports = sports;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

    public List<String> getSports() {
        return sports;
    }
}
