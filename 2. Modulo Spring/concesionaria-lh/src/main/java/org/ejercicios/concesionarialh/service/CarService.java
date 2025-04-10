package org.ejercicios.concesionarialh.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicios.concesionarialh.dto.CarDTO;
import org.ejercicios.concesionarialh.entity.Car;
import org.ejercicios.concesionarialh.exception.NotFoundException;
import org.ejercicios.concesionarialh.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<CarDTO> getAllCars() {
        List<Car> cars = repository.getAllCars();
        if(cars.isEmpty()) {
            throw new NotFoundException("There are no cars loaded");
        }

        ObjectMapper mapper = new ObjectMapper();
        return cars.stream().map(c -> mapper.convertValue(c, CarDTO.class)).toList();
    }

    public List<CarDTO> getCarsByDate(LocalDate since, LocalDate until) {
        List<Car> cars = repository.getCarsByDates(since, until);
        if(cars.isEmpty()) {
            throw new NotFoundException("No cars between those dates were found");
        }

        ObjectMapper mapper = new ObjectMapper();
        return cars.stream().map(c -> mapper.convertValue(c, CarDTO.class)).toList();
    }

    public CarDTO getCar(int id) {
        Car car = repository.getCar(id);
        if(car == null) {
            throw new NotFoundException("No car with that id found");
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(car, CarDTO.class);
    }

    public List<CarDTO> getCarsByPrice(int since, int to) {
        List<Car> cars = repository.getCarsByPrice(since, to);
        if(cars.isEmpty()) {
            throw new NotFoundException("No cars found in that range of prices");
        }

        ObjectMapper mapper = new ObjectMapper();
        return cars.stream().map(c -> mapper.convertValue(c, CarDTO.class)).toList();
    }
}
