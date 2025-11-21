package com.jetbrains.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)

                .oauth2Login(Customizer.withDefaults())

                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))

                .authorizeExchange(exchanges -> exchanges

                        .pathMatchers("/actuator/health").permitAll()

                        .pathMatchers("/login/**").permitAll()

                        .pathMatchers("/employees/**").hasRole("admin")

                        .pathMatchers("/certificates/**").hasAnyRole("admin", "user")

                        .anyExchange().authenticated()
                );

        return http.build();
    }
}