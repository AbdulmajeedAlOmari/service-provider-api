package dev.alomari.service.provider.platform.data.common;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ActivatableEntity extends BaseEntity {

    @NotNull
    @Column(name = "ACTIVITY_STATUS")
    private Boolean activityStatus = false;
}
