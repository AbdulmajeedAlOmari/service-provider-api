package dev.alomari.service.provider.platform.data.role;

import dev.alomari.service.provider.platform.data.privilege.Privilege;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "SPA_ROLE")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SPA_ROLE_PRIVILEGE",
            joinColumns = @JoinColumn(name = "FK_ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_PRIVILEGE_ID"))
    private Set<Privilege> privileges;
}
