package dev.alomari.service.provider.platform.utility.constants;

import lombok.Getter;

@Getter
public enum Authorities {
    //@formatter:off
    PROPOSALS_VIEW_ALL(""),
    ORDERS_VIEW_ALL(""),
    ORDERS_LIST_ALL(""),
    //@formatter:on
    ;

    private String authority;

    Authorities(String authority) {
        this.authority = authority;
    }
}
