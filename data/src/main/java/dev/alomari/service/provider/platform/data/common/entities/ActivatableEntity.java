package dev.alomari.service.provider.platform.data.common.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class ActivatableEntity extends BaseEntity {

    @NotNull
    @Column(name = "ACTIVITY_STATUS")
    private Boolean activityStatus = false;
}
