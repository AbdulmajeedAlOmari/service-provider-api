package dev.alomari.service.provider.platform.controller.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.core.index.AuthService;
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
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(Routes.IS_ALIVE_V1)
    public ResponseEntity<Boolean> isAlive() {
        return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Authentication> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    @JsonView({ View.AuthView.class })
    public ResponseEntity<Authentication> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }
}
