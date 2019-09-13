package dev.alomari.service.provider.platform.data.common;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import java.util.Date;

public class AuditingEntity extends BaseEntity {

    @Nullable
    @CreatedBy
    @Column(name = "CREATED_BY")
    String createdBy;

    @Nullable
    @Column(name = "ACTION_TAKEN_BY")
    String actionTakenBy;

    @Nullable
    @Column(name = "ACTION_TAKEN_AT")
    Date actionTakenAt;
}
