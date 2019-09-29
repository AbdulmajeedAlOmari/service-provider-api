package dev.alomari.service.provider.platform.data.address;

import dev.alomari.service.provider.platform.data.common.AuditingEntity;
import dev.alomari.service.provider.platform.data.security.user.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SPA_ADDRESS")
@Getter
@Setter
public class Address extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FK_USER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @NotBlank
    @Column(name = "LABEL")
    private String label;

    @NotBlank
    @Column(name = "STATUS")
    private AddressStatus status = AddressStatus.ACTIVE;

    @NotBlank
    @Column(name = "CITY")
    private String city;

    @NotBlank
    @Column(name = "COUNTRY")
    private String country;

    @NotBlank
    @Column(name = "DISTRICT")
    private String district;

    @NotBlank
    @Column(name = "STREET")
    private String street;

    @NotBlank
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
}
