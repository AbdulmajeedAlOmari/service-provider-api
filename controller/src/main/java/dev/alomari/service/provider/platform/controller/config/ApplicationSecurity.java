package dev.alomari.service.provider.platform.controller.config;

import dev.alomari.service.provider.platform.utility.constants.Routes;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO: Remove ".anyRequest().permitAll()"
        http
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and().authorizeRequests()
                .anyRequest().permitAll()
//                .antMatchers(Routes.INDEX_ROUTE_V1 + Routes.IS_ALIVE_V1).permitAll()
//                .anyRequest().authenticated()
                .and().formLogin().loginPage(Routes.LOGIN_V1).permitAll()
                .and().httpBasic();
    }
}
