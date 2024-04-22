package com.barutta02.authsystem.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity 
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true) //role based security
public class SecurityConfig {

    private final JwtFilter jwtAuthFilter; // final because it is a dependency that we need to inject and requiredargsconstructor will inject it
    private final AuthenticationProvider authenticationProvider; //auth provider that we created

    /*
     * This method configures the security filter chain.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
        http
                .cors(withDefaults()) // Cross-Origin Resource Sharing 
                .csrf(AbstractHttpConfigurer::disable) // Cross-Site Request Forgery
                .authorizeHttpRequests(req ->
                        req.requestMatchers(
                                        "/auth/**", // all requests that start with /auth
                                        "/v2/api-docs",
                                        "/v3/api-docs",
                                        "/v3/api-docs/**",
                                        "/swagger-resources",
                                        "/swagger-resources/**",
                                        "/configuration/ui",
                                        "/configuration/security",
                                        "/swagger-ui/**",
                                        "/webjars/**",
                                        "/swagger-ui.html"
                                )
                                    .permitAll()
                                .anyRequest()
                                    .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS)) // jwt is stateless, spring security does not need to create a session, for each request the token is validated
                .authenticationProvider(authenticationProvider) // custom authentication provider that we created
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // jwt filter that we created that is done before the username password authentication filter, for example i control before if the token is valid, the user is authenticated...

        return http.build();
    }
}
