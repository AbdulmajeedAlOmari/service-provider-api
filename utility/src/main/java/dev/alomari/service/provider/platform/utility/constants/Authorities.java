package dev.alomari.service.provider.platform.utility.constants;

import lombok.Getter;

@Getter
public enum Authorities {
    //@formatter:off
    PROPOSALS_VIEW_ALL(""),

    /* Orders */
    ORDERS_VIEW_ALL("ORDERS:VIEW_ALL"),
    ORDERS_LIST_ALL("ORDERS:LIST_ALL"),
    ORDERS_REPLY_ALL("ORDERS:REPLY_ALL"),
    //@formatter:on
    ;

    private String authority;

    Authorities(String authority) {
        this.authority = authority;
    }
}
