package com.thanura.dep8;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class AppInitializer {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean

    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(
                        authManager->authManager.antMatchers("api/v1/users/{userId}/**")
                )
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST,"api/v1/users")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class,args);

    }
}
