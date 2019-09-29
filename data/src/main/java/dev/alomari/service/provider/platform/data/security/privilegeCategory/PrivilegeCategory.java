package dev.alomari.service.provider.platform.data.security.privilegeCategory;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SPA_PRIVILEGE_CATEGORY")
@Getter
@Setter
public class PrivilegeCategory {

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

    @NotBlank
    @Column(name = "DESCRIPTION_EN")
    private String descriptionEn;

    @NotBlank
    @Column(name = "DESCRIPTION_AR")
    private String descriptionAr;
}
