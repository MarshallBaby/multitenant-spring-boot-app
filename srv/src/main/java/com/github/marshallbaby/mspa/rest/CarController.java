package com.github.marshallbaby.mspa.rest;

import com.github.marshallbaby.mspa.domain.Car;
import com.github.marshallbaby.mspa.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

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

}
