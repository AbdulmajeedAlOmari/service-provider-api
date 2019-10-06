package dev.alomari.service.provider.platform.data.order;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.address.Address;
import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.common.validation.groups.Validation;
import dev.alomari.service.provider.platform.data.order.listing.Listing;
import dev.alomari.service.provider.platform.data.security.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "SPA_ORDER")
@Getter
@Setter
public class Order extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    @JsonView({ View.SimpleView.class })
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ADDRESS_ID")
    private Address address;

    @NotNull(groups = { Validation.Input.class })
    @Column(name = "STATUS")
    @JsonView({ View.SimpleView.class })
    private OrderStatus status;

    @Nullable
    @Column(name = "COMMENT")
    @JsonView({ View.SimpleView.class })
    private String comment;

    @NotEmpty(groups = { Validation.Input.class })
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonView({ View.SimpleView.class })
    private Set<Listing> listings;
}
