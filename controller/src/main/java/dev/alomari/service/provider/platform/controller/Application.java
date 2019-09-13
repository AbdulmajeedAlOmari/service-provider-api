package dev.alomari.service.provider.platform.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "dev.alomari.service.provider.platform.controller",
        "dev.alomari.service.provider.platform.core"
})
@EntityScan("dev.alomari.service.provider.platform.data")
@EnableJpaRepositories("dev.alomari.service.provider.platform.data")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
