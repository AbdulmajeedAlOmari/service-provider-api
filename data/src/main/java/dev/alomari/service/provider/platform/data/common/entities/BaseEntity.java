package dev.alomari.service.provider.platform.data.common.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.util.Date;

@Data
public class BaseEntity {

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "CREATED_AT")
    private Date createdAt = new Date();

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private Date updatedAt;

}
