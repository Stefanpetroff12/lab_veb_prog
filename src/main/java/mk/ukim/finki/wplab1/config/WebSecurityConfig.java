package mk.ukim.finki.wplab1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/h2/**").permitAll() // Allow access to H2 console
                        .anyRequest().authenticated()          // Secure other endpoints
                )
                .csrf(csrf -> csrf.disable())               // Disable CSRF for H2 console
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()) // Allow frames for H2 console
                );

        return http.build();
    }
}
