package com.github.marshallbaby.mspa.rest;

import com.github.marshallbaby.mspa.domain.Shop;
import com.github.marshallbaby.mspa.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public List<Shop> getShops() {

        log.info("Getting all shops.");
        return shopService.getShops();
    }

    @GetMapping("/{id}")
    public Shop findShop(@PathVariable Long id) {

        log.info("Getting shop by id: [{}].", id);
        return shopService.findShop(id);
    }

    @PostMapping
    public Shop createShop(@RequestBody Shop shop) {

        log.info("Creating shop: [{}].", shop);
        return shopService.createShop(shop);
    }

    @PutMapping
    public Shop updateShop(@RequestBody Shop shop) {

        log.info("Updating shop with id: [{}]", shop.getId());
        return shopService.updateShop(shop);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {

        log.info("Deleting shop by id: [{}].", id);
        shopService.deleteShop(id);
    }
}
