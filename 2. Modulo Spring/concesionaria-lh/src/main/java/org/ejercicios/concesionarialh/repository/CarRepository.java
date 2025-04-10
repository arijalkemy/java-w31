package org.ejercicios.concesionarialh.repository;

import org.ejercicios.concesionarialh.entity.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CarRepository {

    private List<Car> carList;
    private int carCount;

    public CarRepository() {
        carList = new ArrayList<>();
        carCount = 0;
    }

    public int addCar(Car car) {
        carCount += 1;
        car.setId(carCount);
        carList.add(car);
        return carCount;
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public boolean isBetweenDates(LocalDate since, LocalDate until, LocalDate objDate) {
        return (objDate.isEqual(since) || objDate.isAfter(since)) &&
                (objDate.isEqual(until) || objDate.isBefore(until));
    }

    public List<Car> getCarsByDates(LocalDate since, LocalDate until) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return carList.stream().filter(c -> {
            LocalDate date = LocalDate.parse(c.getManufacturingDate(), formatter);
            return isBetweenDates(since, until, date);
        }).toList();
    }


    public Car getCar(int id) {
        for(Car c: carList) {
            if(c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    public List<Car> getCarsByPrice(int since, int to) {
        return carList.stream().filter(c -> Integer.parseInt(c.getPrice()) >= since).filter(c -> Integer.parseInt(c.getPrice()) <= to).toList();
    }
}
