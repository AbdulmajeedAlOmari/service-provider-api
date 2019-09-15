package dev.alomari.service.provider.platform.data.user;

import dev.alomari.service.provider.platform.data.common.ActivatableEntity;
import dev.alomari.service.provider.platform.data.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "SPA_USER")
@Getter
@Setter
public class User extends ActivatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SPA_USER_ROLE",
            joinColumns = @JoinColumn(name = "FK_USER_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID", nullable = false)
    )
    private Set<Role> roles;

    @NotNull
    @NotBlank
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Size(min = 8)
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Size(min = 9, max = 50)
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;
}
