package com.easyapp.mathias.adm.mathias.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class FirebaseSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {
                    req.requestMatchers(HttpMethod.GET, "/auth/**").permitAll();
                    //frontend
                    req.requestMatchers("/","index.html").permitAll();
                    req.requestMatchers("account/**").permitAll();
                    req.requestMatchers("css/**", "js/**", "config/**").permitAll();
                    req.anyRequest().permitAll();
                })
                .addFilterBefore(new FirebaseFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
