package dev.alomari.service.provider.platform.data.common.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class AuditingEntity extends BaseEntity {

    @Nullable
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @Nullable
    @Column(name = "ACTION_TAKEN_BY")
    private String actionTakenBy;

    @Nullable
    @Column(name = "ACTION_TAKEN_AT")
    private Date actionTakenAt;
}
