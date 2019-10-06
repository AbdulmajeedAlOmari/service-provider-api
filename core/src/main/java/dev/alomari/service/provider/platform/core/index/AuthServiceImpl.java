package dev.alomari.service.provider.platform.core.index;

import dev.alomari.service.provider.platform.data.security.role.Role;
import dev.alomari.service.provider.platform.data.security.role.RoleRepository;
import dev.alomari.service.provider.platform.data.security.user.LoginRequest;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.data.security.user.UserRepository;
import dev.alomari.service.provider.platform.utility.constants.Roles;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import dev.alomari.service.provider.platform.utility.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public Authentication login(LoginRequest loginRequest) {
        User user = userRepository.findOneByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new ServiceProviderException(ServiceProviderError.AUTHENTICATION_FAILURE)
        );

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new ServiceProviderException(ServiceProviderError.AUTHENTICATION_FAILURE);
        }

        return SecurityUtil.signInUser(user);
    }

    @Transactional
    @Override
    public Authentication register(User user) {
        Boolean exists = userRepository.existsByEmail(user.getEmail());

        if(exists) {
            throw new ServiceProviderException(ServiceProviderError.EMAIL_ALREADY_REGISTERED);
        }

        user.setRoles(getDefaultRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);

        return SecurityUtil.signInUser(user);
    }

    private Set<Role> getDefaultRole() {
        Set<Role> role = new HashSet<>();

        Role userRole = roleRepository.findById(Roles.CUSTOMER.getId()).orElse(null);
        role.add(userRole);

        return role;
    }
}
