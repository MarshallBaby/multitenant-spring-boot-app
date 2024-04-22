package com.github.marshallbaby.mspa.service;

import com.github.marshallbaby.mspa.domain.Car;
import com.github.marshallbaby.mspa.repo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car findCar(Long carId) {

        return carRepository.findById(carId).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
    }

    public Car createCar(Car car) {

        return carRepository.save(car);
    }

}
