package dev.alomari.service.provider.platform.data.order.payment;

import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.order.proposal.Proposal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SPA_PAYMENT")
@Getter
@Setter
public class Payment extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FK_PROPOSAL_ID")
    private Proposal proposal;

    @NotNull
    @Column(name = "STATUS")
    private PaymentStatus status = PaymentStatus.PENDING;

    @Nullable
    @Column(name = "METHOD")
    private PaymentMethod method;

    @Nullable
    @Column(name = "BANK")
    private String bank;

    @Nullable
    @Column(name = "REFERENCE")
    private String reference;
}
