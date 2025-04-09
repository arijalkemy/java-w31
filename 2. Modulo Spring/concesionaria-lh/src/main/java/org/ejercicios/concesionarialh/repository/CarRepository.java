package org.ejercicios.concesionarialh.repository;

import org.ejercicios.concesionarialh.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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



}
