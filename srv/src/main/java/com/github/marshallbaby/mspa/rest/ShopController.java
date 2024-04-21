package com.github.marshallbaby.mspa.rest;

import com.github.marshallbaby.mspa.domain.Shop;
import com.github.marshallbaby.mspa.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/{id}")
    public Shop findShop(@PathVariable UUID id) {

        log.info("Getting shop by id: [{}].", id);
        return shopService.findShop(id);
    }

    @PostMapping
    public Shop createShop(@RequestBody Shop shop) {

        log.info("Creating shop: [{}].", shop);
        return shopService.createShop(shop);
    }
}
