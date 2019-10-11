package dev.alomari.service.provider.platform.core.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "proposal")
@Data
public class ProposalProperties {

    private BigDecimal maxPrice;

}