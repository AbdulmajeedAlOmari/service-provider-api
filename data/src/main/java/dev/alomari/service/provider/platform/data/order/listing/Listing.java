package dev.alomari.service.provider.platform.data.order.listing;

import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FK_ORDER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @Nullable
    @Column(name = "DETAILS")
    private String details;
}
