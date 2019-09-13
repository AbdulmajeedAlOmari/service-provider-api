package dev.alomari.service.provider.platform.controller.controllers;

import dev.alomari.service.provider.platform.utility.constants.Routes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.INDEX_ROUTE_V1)
public class IndexController {

    @GetMapping(Routes.IS_ALIVE_V1)
    public ResponseEntity<Boolean> isAlive() {
        return ResponseEntity.ok(true);
    }

}
