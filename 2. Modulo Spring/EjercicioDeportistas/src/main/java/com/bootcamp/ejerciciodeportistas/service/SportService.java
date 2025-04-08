package com.bootcamp.ejerciciodeportistas.service;

import com.bootcamp.ejerciciodeportistas.dto.SportDto;
import com.bootcamp.ejerciciodeportistas.entity.Person;
import com.bootcamp.ejerciciodeportistas.entity.Sport;
import com.bootcamp.ejerciciodeportistas.exception.NotFoundException;
import com.bootcamp.ejerciciodeportistas.repository.ISportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportService implements ISportService{
    @Autowired
    ISportRepository sportRepository;

    public List<SportDto> allSports(){
        List<Sport> sports = sportRepository.allSports();
        if(sports.isEmpty()){
            throw new NotFoundException("No se encontro ninguna deporte.");
        }
        return sports.stream().map(sport -> new SportDto(sport.getNombre(), sport.getNivel())).collect(Collectors.toList());
    }
    public SportDto findSport(String name){
        Optional<Sport> sport = sportRepository.findSport(name);
        if(!sport.isPresent()){
            throw new NotFoundException("No se encontro el deporte "+ name);
        }
        return new SportDto(sport.get().getNombre(), sport.get().getNivel());
    }
}
