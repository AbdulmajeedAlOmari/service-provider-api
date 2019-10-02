package dev.alomari.service.provider.platform.data.common.entities;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ActivatableEntity extends BaseEntity {

    @NotNull
    @Column(name = "ACTIVITY_STATUS")
    private Boolean activityStatus = false;
}
