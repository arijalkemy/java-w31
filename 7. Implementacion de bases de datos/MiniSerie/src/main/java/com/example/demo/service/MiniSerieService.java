package com.example.demo.service;

import com.example.demo.model.MiniSerie;
import com.example.demo.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {

    @Autowired
    IMiniSerieRepository miniSerieRepository;

    public void  save(){
        MiniSerie miniSerie = new MiniSerie();
        miniSerie.setName("El eternauta");
        miniSerie.setRating(10.0);
        miniSerie.setAmount_of_awards(1030);
        miniSerieRepository.save(miniSerie);
    }
}
