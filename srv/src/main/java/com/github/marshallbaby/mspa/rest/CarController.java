package com.github.marshallbaby.mspa.rest;

import com.github.marshallbaby.mspa.domain.Car;
import com.github.marshallbaby.mspa.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> getCars() {

        log.info("Getting all cars.");
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public Car findCar(@PathVariable Long id) {

        log.info("Getting car by id: [{}].", id);
        return carService.findCar(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {

        log.info("Creating car: [{}].", car);
        return carService.createCar(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car) {

        log.info("Updating car with id: [{}].", car.getId());
        return carService.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {

        log.info("Deleting car: [{}].", id);
        carService.deleteCar(id);
    }

}
