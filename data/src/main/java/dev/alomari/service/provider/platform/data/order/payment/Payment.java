package dev.alomari.service.provider.platform.data.order.payment;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.entities.AuditingEntity;
import dev.alomari.service.provider.platform.data.common.jsonviews.List;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
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
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private Long id;

    @OneToOne
    @JoinColumn(name = "FK_PROPOSAL_ID")
    private Proposal proposal;

    @NotNull
    @Column(name = "STATUS")
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private PaymentStatus status = PaymentStatus.PENDING;

    @Nullable
    @Column(name = "METHOD")
    @JsonView({ View.DetailedView.class, List.SimpleList.class })
    private PaymentMethod method;

    @Nullable
    @Column(name = "BANK")
    @JsonView({ View.DetailedView.class })
    private String bank;

    @Nullable
    @Column(name = "REFERENCE")
    @JsonView({ View.DetailedView.class })
    private String reference;
}
