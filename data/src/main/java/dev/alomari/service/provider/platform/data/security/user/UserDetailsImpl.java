package dev.alomari.service.provider.platform.data.security.user;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
public class UserDetailsImpl implements UserDetails {
    @Getter
    @JsonView({ View.AuthView.class })
    private User user;

    @JsonView({ View.AuthView.class })
    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(User user, List<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActivityStatus();
    }

    public boolean equals(Object object) {
        return object instanceof UserDetails && this.getUsername().equals(((UserDetails)object).getUsername());
    }

    public int hashCode() {
        return this.user.getEmail().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("Email: ").append(this.user.getEmail()).append("; ");
        sb.append("Password: [PROTECTED]; ");
        sb.append("Mobile Number: ").append(this.user.getMobileNumber()).append("; ");
        if (this.authorities != null && !this.authorities.isEmpty()) {
            sb.append("Granted Authorities: ");
            boolean first = true;
            Iterator authorityIterator = this.authorities.iterator();

            while(authorityIterator.hasNext()) {
                GrantedAuthority auth = (GrantedAuthority)authorityIterator.next();
                if (!first) {
                    sb.append(",");
                }

                first = false;
                sb.append(auth);
            }
        } else {
            sb.append("Not granted any authorities");
        }

        return sb.toString();
    }
}
