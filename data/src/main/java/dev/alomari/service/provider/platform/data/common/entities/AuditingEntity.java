package dev.alomari.service.provider.platform.data.common.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Column;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuditingEntity extends BaseEntity {

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "ACTION_TAKEN_BY")
    private String actionTakenBy;

    @Column(name = "ACTION_TAKEN_AT")
    private Date actionTakenAt;
}
