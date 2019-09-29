package dev.alomari.service.provider.platform.data.order;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.AuditingEntity;
import dev.alomari.service.provider.platform.data.order.listing.Listing;
import dev.alomari.service.provider.platform.utility.constants.JsonViews;
import lombok.Getter;
import lombok.Setter;

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
    @Size(min = 1)
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Listing> listings;
}
