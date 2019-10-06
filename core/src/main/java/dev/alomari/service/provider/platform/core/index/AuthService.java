package dev.alomari.service.provider.platform.core.index;

import dev.alomari.service.provider.platform.data.security.user.LoginRequest;
import dev.alomari.service.provider.platform.data.security.user.User;
import org.springframework.security.core.Authentication;

public interface AuthService {
    Authentication login(LoginRequest loginRequest);

    Authentication register(User user);
}
