package dev.alomari.service.provider.platform.data.order.proposal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.common.jsonviews.List;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.data.order.payment.Payment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "SPA_PROPOSAL")
@Getter
@Setter
public class Proposal extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FK_ORDER_ID", nullable = false)
    @JsonView({ List.SimpleList.class })
    @JsonBackReference
    private Order order;

    @Nullable
    @OneToOne
    @JoinColumn(name = "FK_PAYMENT_ID")
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private Payment payment;

    @NotNull
    @Column(name = "STATUS")
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private ProposalStatus status = ProposalStatus.PENDING;

    @NotNull
    @Min(0)
    @Column(name = "PRICE")
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private BigDecimal price;

    @Nullable
    @Column(name = "NOTE")
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private String note;
}
