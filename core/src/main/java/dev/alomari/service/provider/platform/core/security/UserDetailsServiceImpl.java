package dev.alomari.service.provider.platform.core.security;

import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.data.security.user.UserDetailsImpl;
import dev.alomari.service.provider.platform.data.security.user.UserRepository;
import dev.alomari.service.provider.platform.utility.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User name was not found")
        );

        List<GrantedAuthority> authorities = SecurityUtil.getAuthorities(user);
        UserDetails userDetails = new UserDetailsImpl(user, authorities);

        return userDetails;
    }
}
