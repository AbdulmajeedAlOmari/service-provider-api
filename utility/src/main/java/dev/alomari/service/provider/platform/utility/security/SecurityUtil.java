package dev.alomari.service.provider.platform.utility.security;

import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.security.privilege.Privilege;
import dev.alomari.service.provider.platform.data.security.role.Role;
import dev.alomari.service.provider.platform.data.security.user.MyUsernamePasswordAuthenticationToken;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.data.security.user.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class SecurityUtil {

    public static void recordAction(AuditingEntity auditingEntity) {
        User currentUser = getCurrentUser();

        auditingEntity.setActionTakenAt(new Date());
        auditingEntity.setActionTakenBy("[ " + currentUser.getId() + " ] " + currentUser.getFirstName() + " " + currentUser.getLastName());
    }

    public static Authentication signInUser(User user) {
        List<GrantedAuthority> roles = getAuthorities(user);
        UserDetailsImpl springSecurityUser = new UserDetailsImpl(user, roles);
        Authentication authentication = new MyUsernamePasswordAuthenticationToken(springSecurityUser, user.getPassword(), roles);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }

    public static User getCurrentUser() {
        User user = null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth;

        if (securityContext != null) {
            auth = securityContext.getAuthentication();

            if (auth != null) {
                Object principal = auth.getPrincipal();

                if (principal instanceof UserDetailsImpl) {
                    UserDetailsImpl authUser = (UserDetailsImpl) principal;
                    user = authUser.getUser();
                }
            }
        }

        return user;
    }

    public static List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : user.getRoles()) {
            Set<Privilege> privileges = role.getPrivileges();

            authorities.addAll(privileges);
        }

        return authorities;
    }

    public static boolean hasAuthority(final String authority) {
        User currentUser = getCurrentUser();
        List<GrantedAuthority> userAuthorities = getAuthorities(currentUser);
        return userAuthorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equalsIgnoreCase(authority));
    }
}
