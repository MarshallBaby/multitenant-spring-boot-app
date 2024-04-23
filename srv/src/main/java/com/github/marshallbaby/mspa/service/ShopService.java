package com.github.marshallbaby.mspa.service;

import com.github.marshallbaby.mspa.domain.Shop;
import com.github.marshallbaby.mspa.repo.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public Shop findShop(Long shopId) {

        return shopRepository.findById(shopId)
                .orElseThrow(() -> new RuntimeException("NOT_FOUND"));
    }

    public Shop createShop(Shop shop) {

        return shopRepository.save(shop);
    }

}