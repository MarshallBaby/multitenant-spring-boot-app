package com.github.marshallbaby.mspa.service;

import com.github.marshallbaby.mspa.domain.Car;
import com.github.marshallbaby.mspa.exception.NotFoundException;
import com.github.marshallbaby.mspa.repo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars() {

        return carRepository.findAll();
    }

    public Car findCar(Long carId) {

        return findCarById(carId);
    }

    public Car createCar(Car car) {

        return carRepository.save(car);
    }

    public Car updateCar(Car car) {

        findCarById(car.getId());
        return carRepository.save(car);
    }

    public void deleteCar(Long carId) {

        carRepository.deleteById(carId);
    }

    public Car findCarById(Long carId) {

        return carRepository.findById(carId).orElseThrow(
                () -> new NotFoundException(format("Could not found car by id: [%s].", carId)));
    }

}
