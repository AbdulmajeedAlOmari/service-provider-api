package dev.alomari.service.provider.platform.data.order.proposal;

import dev.alomari.service.provider.platform.data.common.AuditingEntity;
import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.data.order.payment.Payment;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FK_ORDER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;

    @Nullable
    @OneToOne
    @JoinColumn(name = "FK_PAYMENT_ID")
    private Payment payment;

    @NotNull
    @Column(name = "STATUS")
    private ProposalStatus status = ProposalStatus.PENDING;

    @NotNull
    @Min(0)
    @Column(name = "PRICE")
    private BigDecimal price;

    @Nullable
    @Column(name = "NOTE")
    private String note;
}
