package com.ironhack.Lab_4_08.Lab_4_08.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Autowired
    private CustomAuthenticationManager auth;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
        http.authenticationManager(auth);
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN", "SUPERUSER")
                .antMatchers(HttpMethod.PATCH, "/student/**").hasAnyRole("ADMIN", "SUPERUSER")
                .antMatchers(HttpMethod.PUT, "/student/**").hasAnyRole("ADMIN", "SUPERUSER")
                .antMatchers(HttpMethod.PATCH, "/spell/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/spell/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/student/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/student/**").permitAll()
                .antMatchers(HttpMethod.GET, "/spell/**").permitAll()
                .antMatchers(HttpMethod.GET, "/house-assignment/**").permitAll()
                .anyRequest().permitAll();
        return http.build();
    }
}
