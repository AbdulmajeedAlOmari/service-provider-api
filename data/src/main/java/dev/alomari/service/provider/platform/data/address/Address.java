package dev.alomari.service.provider.platform.data.address;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.common.validation.groups.Validation;
import dev.alomari.service.provider.platform.data.security.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SPA_ADDRESS")
@Data
@EqualsAndHashCode(callSuper = false)
public class Address extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FK_USER_ID", nullable = false)
    private User user;

    @NotBlank(groups = { Validation.Input.class })
    @Column(name = "LABEL")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private String label;

    @NotNull
    @Column(name = "STATUS")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private AddressStatus status = AddressStatus.ACTIVE;

    @NotBlank(groups = { Validation.Input.class })
    @Column(name = "CITY")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private String city;

    @NotBlank(groups = { Validation.Input.class })
    @Column(name = "COUNTRY")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private String country;

    @NotBlank(groups = { Validation.Input.class })
    @Column(name = "DISTRICT")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private String district;

    @NotBlank(groups = { Validation.Input.class })
    @Column(name = "STREET")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private String street;

    @NotBlank(groups = { Validation.Input.class })
    @Column(name = "HOUSE_NUMBER")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private String houseNumber;
}
