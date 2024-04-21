package com.github.marshallbaby.mspa.repo;

import com.github.marshallbaby.mspa.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShopRepository extends JpaRepository<Shop, UUID> {
}
