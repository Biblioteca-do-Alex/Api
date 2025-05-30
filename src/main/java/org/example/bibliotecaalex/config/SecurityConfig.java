package org.example.bibliotecaalex.config;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.example.bibliotecaalex.JwtAuthenticatorFilter;
import org.example.bibliotecaalex.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new JwtAuthenticatorFilter(userDetailsService, secretKey()), UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(userDetailsService);
////                .exceptionHandling(exceptions -> exceptions
////                        .authenticationEntryPoint((request, response, authException) -> {
////                            response.setContentType("application/json");
////                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
////                            response.getWriter().write("{\"error\": \"Unauthorized: " +
////                                    authException.getMessage() + "\"}");
////                        })
////                        .accessDeniedHandler((request, response, accessDeniedException) -> {
////                            response.setContentType("application/json");
////                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
////                            response.getWriter().write("{\"error\": \"Access Denied: " +
////                                    accessDeniedException.getMessage() + "\"}");
////                        })
//                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecretKey secretKey(){
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
}