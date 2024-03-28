package com.springbooteshop.SpringBootEShop.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final DataSource securityDataSource;

  public SecurityConfig(DataSource securityDataSource) {
    this.securityDataSource = securityDataSource;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable()) // Disable CSRF protection
        .authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers("/", "/h2-console", "/search", "/cart/**")
                    .permitAll()
                    .requestMatchers("/book/**", "/orders/**")
                    .hasAuthority("ADMIN"))
        .formLogin(form -> form.loginPage("/login").permitAll())
        .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/"))
        .headers(
            headers ->
                headers.addHeaderWriter(
                    (request, response) ->
                        response.setHeader(
                            "X-Frame-Options",
                            "SAMEORIGIN")) // Allow framing only from the same origin
            );

    return http.build();
  }

  @Bean
  public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder =
        http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.jdbcAuthentication().dataSource(securityDataSource);
    return authenticationManagerBuilder.build();
  }
}
