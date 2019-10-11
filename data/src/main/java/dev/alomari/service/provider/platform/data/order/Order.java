package dev.alomari.service.provider.platform.data.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.address.Address;
import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.common.jsonviews.List;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.common.validation.groups.Validation;
import dev.alomari.service.provider.platform.data.order.listing.Listing;
import dev.alomari.service.provider.platform.data.order.proposal.Proposal;
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
    @JsonView({ View.SimpleView.class, View.DetailedView.class, List.SimpleList.class })
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    @NotNull(groups = { Validation.Input.class })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ADDRESS_ID")
    @JsonView({ View.DetailedView.class })
    private Address address;

    @NotNull
    @Column(name = "STATUS")
    @JsonView({ View.SimpleView.class, View.DetailedView.class, List.SimpleList.class })
    private OrderStatus status;

    @Nullable
    @Column(name = "COMMENT")
    @JsonView({ View.SimpleView.class, View.DetailedView.class, List.SimpleList.class })
    private String comment;

    @NotEmpty(groups = { Validation.Input.class })
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private java.util.List<Listing> listings;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonView({ View.DetailedView.class })
    @JsonManagedReference
    private java.util.List<Proposal> proposals;
}
