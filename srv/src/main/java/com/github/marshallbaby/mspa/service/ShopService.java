package com.github.marshallbaby.mspa.service;

import com.github.marshallbaby.mspa.domain.Shop;
import com.github.marshallbaby.mspa.exception.NotFoundException;
import com.github.marshallbaby.mspa.repo.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public List<Shop> getShops() {

        return shopRepository.findAll();
    }

    public Shop findShop(Long shopId) {

        return findShopById(shopId);
    }

    public Shop createShop(Shop shop) {

        return shopRepository.save(shop);
    }

    public Shop updateShop(Shop shop) {

        findShopById(shop.getId());
        return shopRepository.save(shop);
    }

    public void deleteShop(Long shopId) {

        shopRepository.deleteById(shopId);
    }

    private Shop findShopById(Long shopId) {

        return shopRepository.findById(shopId)
                .orElseThrow(() -> new NotFoundException(format("Could not find shop by id: [%s].", shopId)));
    }

}
