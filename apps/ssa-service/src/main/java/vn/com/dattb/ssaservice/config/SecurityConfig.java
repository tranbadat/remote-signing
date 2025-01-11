package vn.com.dattb.ssaservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/30/2024
 * Version: 1.0.0
 * <p>
 * Description: This class is used to configure the security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${spring.security.oauth2.authorizationserver.endpoint.jwk-set-uri}")
    private String jwkSetUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/v1/auth/login","/actuator/**").permitAll()
                                .anyRequest().permitAll()
                )
                .oauth2ResourceServer(oauth2ResourceServer ->
                        oauth2ResourceServer
                                .jwt(jwt -> jwt
                                        .jwtAuthenticationConverter(jwtAuthenticationConverter())
                                )
                );

        return http.build();
    }

    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {

        return new JwtAuthenticationConverter();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }
}

