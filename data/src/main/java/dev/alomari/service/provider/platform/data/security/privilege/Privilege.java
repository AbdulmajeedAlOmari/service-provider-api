package dev.alomari.service.provider.platform.data.security.privilege;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
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
    @JsonView({ g })
    private Short id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_PRIVILEGE_CATEGORY_ID")
    private PrivilegeCategory category;

    @NotBlank
    @Column(name = "ACTION")
    @JsonView({ View.AuthView.class })
    private String action;

    @NotBlank
    @Column(name = "NAME_AR")
    @JsonView({ View.AuthView.class })
    private String arName;

    @NotBlank
    @Column(name = "NAME_EN")
    @JsonView({ View.AuthView.class })
    private String enName;

    @JsonIgnore
    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    private Set<Role> roles;

    @Override
    public String getAuthority() {
        return action;
    }
}
