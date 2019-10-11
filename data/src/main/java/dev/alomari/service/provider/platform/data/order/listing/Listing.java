package dev.alomari.service.provider.platform.data.order.listing;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.common.validation.groups.Validation;
import dev.alomari.service.provider.platform.data.order.Order;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SPA_LISTING")
@Getter
@Setter
public class Listing extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FK_ORDER_ID", nullable = false)
    private Order order;

    @NotBlank(groups = { Validation.Input.class })
    @Column(name = "NAME")
    @JsonView({ View.SimpleView.class, View.DetailedView.class })
    private String name;

    @Nullable
    @Column(name = "DETAILS")
    @JsonView({ View.DetailedView.class })
    private String details;
}
