package dev.alomari.service.provider.platform.data.security.privilege;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.alomari.service.provider.platform.data.security.privilegeCategory.PrivilegeCategory;
import dev.alomari.service.provider.platform.data.security.role.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "SPA_PRIVILEGE")
@Getter
@Setter
public class Privilege implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Short id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_PRIVILEGE_CATEGORY_ID")
    private PrivilegeCategory category;

    @NotBlank
    @Column(name = "ACTION")
    private String action;

    @NotBlank
    @Column(name = "NAME_AR")
    private String arName;

    @NotBlank
    @Column(name = "NAME_EN")
    private String enName;

    @JsonIgnore
    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    private Set<Role> roles;

    @Override
    public String getAuthority() {
        return action;
    }
}
