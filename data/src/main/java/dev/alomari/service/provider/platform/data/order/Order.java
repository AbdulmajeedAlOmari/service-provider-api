package dev.alomari.service.provider.platform.data.order;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.data.common.AuditingEntity;
import dev.alomari.service.provider.platform.utility.constants.Views;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "SPA_ORDER")
@Getter
@Setter
public class Order extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    @JsonView({Views.List.class, Views.View.class})
    private Long id;
}
