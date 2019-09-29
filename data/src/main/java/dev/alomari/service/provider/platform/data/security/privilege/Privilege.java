package dev.alomari.service.provider.platform.data.security.privilege;

import dev.alomari.service.provider.platform.data.security.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "SPA_PRIVILEGE")
@Getter
@Setter
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Short id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    private Set<Role> roles;
}
