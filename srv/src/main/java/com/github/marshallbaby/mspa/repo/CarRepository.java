package com.github.marshallbaby.mspa.repo;

import com.github.marshallbaby.mspa.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
