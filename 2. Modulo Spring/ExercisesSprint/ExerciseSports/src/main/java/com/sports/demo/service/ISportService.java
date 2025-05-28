package com.sports.demo.service;

import java.util.List;

import com.sports.demo.dto.PersonDto;
import com.sports.demo.dto.SportDto;

public interface ISportService {
    List<SportDto> findSports();
    List<PersonDto> findSportPerson();

    SportDto getSportByName(String name) throws Exception;
}
