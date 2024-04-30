package com.github.marshallbaby.mspa.rest;

import com.github.marshallbaby.mspa.domain.Shop;
import com.github.marshallbaby.mspa.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shop")
public class ShopController {

    private final ShopService shopService;

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
}
