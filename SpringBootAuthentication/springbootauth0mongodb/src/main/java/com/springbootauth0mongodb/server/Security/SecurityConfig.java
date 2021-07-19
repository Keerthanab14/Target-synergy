package com.springbootauth0mongodb.server.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("https://quickstarts/api")
    private String audience;

    @Value("https://keerthana.us.auth0.com/")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow Swagger to be accessed publicly
        http.authorizeRequests().antMatchers("/v2/api-docs", "/swagger-ui/**", "/swagger-resources",
                "/swagger-resources/configuration/ui", "/swagger-resources/configuration/security").permitAll();

        // Only allow GET requests to '/' to be permitted
        http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/").permitAll().anyRequest().authenticated().and()
                .oauth2ResourceServer().jwt();
    }

    JwtDecoder jwtDecoder() {
        OAuth2TokenValidator<Jwt> withAudience = new AudienceValidator(audience);
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
        OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);

        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);
        jwtDecoder.setJwtValidator(validator);
        return jwtDecoder;
    }
}