package dev.alomari.service.provider.platform.controller.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.core.index.IndexService;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.security.user.LoginRequest;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.utility.constants.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Routes.INDEX_ROUTE_V1)
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping(Routes.IS_ALIVE_V1)
    public ResponseEntity<Boolean> isAlive() {
        return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Authentication> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(indexService.login(loginRequest));
    }

    @PostMapping("/register")
    @JsonView({ View.AuthView.class })
    public ResponseEntity<Authentication> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(indexService.register(user));
    }
}
