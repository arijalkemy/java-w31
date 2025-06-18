package com.mercadolibre.melifrescosg9w31.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**", "/v3/api-docs/**", "/ping").permitAll()
                        .requestMatchers(
                                "/api/v1/fresh-products/list/**",
                                "/api/v1/fresh-products/orders/**"
                        ).hasAnyAuthority("BUYER", "WAREHOUSE_REP")
                        .requestMatchers(
                                "/api/v1/fresh-products/inboundorder/**",
                                "/api/v1/fresh-products/*/warehouse/list",
                                "/api/v1/fresh-products/*/batch/list",
                                "/api/v1/fresh-products/batch/list/due-date/**"
                        ).hasAuthority("WAREHOUSE_REP")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
