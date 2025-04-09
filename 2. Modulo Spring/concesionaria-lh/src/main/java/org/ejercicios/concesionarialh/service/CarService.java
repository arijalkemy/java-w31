package org.ejercicios.concesionarialh.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicios.concesionarialh.dto.CarDTO;
import org.ejercicios.concesionarialh.entity.Car;
import org.ejercicios.concesionarialh.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository repository;
    private final ObjectMapper mapper;

    public CarService(CarRepository repository) {
        this.repository = repository;
        this.mapper = new ObjectMapper();
    }

    public int addCar(CarDTO carDto) {
        Car car = mapper.convertValue(carDto, Car.class);
        return repository.addCar(car);
    }

}
