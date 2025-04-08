package com.bootcamp.ejercicio_covid19.service;

import com.bootcamp.ejercicio_covid19.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository personRepository;
}
