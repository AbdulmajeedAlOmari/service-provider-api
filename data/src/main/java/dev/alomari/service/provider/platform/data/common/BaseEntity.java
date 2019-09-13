package dev.alomari.service.provider.platform.data.common;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.util.Date;

public class BaseEntity {

    @CreatedDate
    @Column(name = "CREATED_AT")
    Date createdAt;
}
