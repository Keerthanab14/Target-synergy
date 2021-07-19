// https://auth0.com/blog/spring-boot-authorization-tutorial-secure-an-api-java/
package com.server.springbootauth0postgres.Security;

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
  @Value("${auth0.audience}")
  private String audience;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuer;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Allow Swagger to be accessed publicly
    http.authorizeRequests().antMatchers("/v2/api-docs", "/swagger-ui/**", "/swagger-resources",
        "/swagger-resources/configuration/ui", "/swagger-resources/configuration/security").permitAll();

    http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/").permitAll() // GET requests don't need auth
        .anyRequest().authenticated().and().oauth2ResourceServer().jwt().decoder(jwtDecoder());
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