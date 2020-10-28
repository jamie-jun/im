package com.jamie.im.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Configuration
@EnableWebFluxSecurity
public class ResouceServer{

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http){
        return http.authorizeExchange()
                .pathMatchers("/**").permitAll()
                .anyExchange().authenticated()
                .and().csrf().disable().build();
    }

}
