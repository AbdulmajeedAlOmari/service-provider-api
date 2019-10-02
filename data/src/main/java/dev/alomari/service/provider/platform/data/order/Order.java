package dev.alomari.service.provider.platform.data.order;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.address.Address;
import dev.alomari.service.provider.platform.data.common.AuditingEntity;
import dev.alomari.service.provider.platform.data.order.listing.Listing;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.utility.constants.JsonViews;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "SPA_ORDER")
@Getter
@Setter
public class Order extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    @JsonView({JsonViews.List.class, JsonViews.View.class})
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ADDRESS_ID")
    private Address address;

    @NotNull
    @Column(name = "STATUS")
    private OrderStatus status;

    @Nullable
    @Column(name = "COMMENT")
    private String comment;

    @NotNull
    @Size(min = 1)
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Listing> listings;
}
