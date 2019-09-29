package dev.alomari.service.provider.platform.data.security.role;

import dev.alomari.service.provider.platform.data.security.privilege.Privilege;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "SPA_ROLE")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Short id;

    @NotBlank
    @Column(name = "NAME_EN")
    private String nameEn;

    @NotBlank
    @Column(name = "NAME_AR")
    private String nameAr;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SPA_ROLE_PRIVILEGE",
            joinColumns = @JoinColumn(name = "FK_ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_PRIVILEGE_ID"))
    private Set<Privilege> privileges;
}
