package dev.alomari.service.provider.platform.controller.config;

import dev.alomari.service.provider.platform.utility.constants.Routes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and().authorizeRequests()
                .antMatchers(Routes.INDEX_ROUTE_V1 + Routes.IS_ALIVE_V1).permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(Routes.INDEX_ROUTE_V1 + "/login").not().authenticated()
                .antMatchers(Routes.INDEX_ROUTE_V1 + "/register").not().authenticated()
                .anyRequest().authenticated()
                .and().formLogin().disable()
                .logout().logoutUrl(Routes.INDEX_ROUTE_V1 + "/logout").permitAll()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
