package dev.alomari.service.provider.platform.utility.constants;

import lombok.Getter;

@Getter
public enum Roles {
    CUSTOMER((short) 1);

    short id;

    Roles(short id) {
        this.id = id;
    }
}
