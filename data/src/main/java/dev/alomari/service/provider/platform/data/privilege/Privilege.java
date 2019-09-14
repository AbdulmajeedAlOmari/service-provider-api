package dev.alomari.service.provider.platform.data.privilege;

import dev.alomari.service.provider.platform.data.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "SPA_PRIVILEGE")
@Getter
@Setter
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    private Set<Role> roles;
}
