package ru.tagall.emulatesystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ru.tagall.emulatesystem.error.ErrorDescription;
import ru.tagall.emulatesystem.error.HttpResponseUtils;
import ru.tagall.emulatesystem.error.model.ApplicationErrorDto;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringConfig extends WebSecurityConfigurerAdapter {

    private final JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
        http.headers().frameOptions().sameOrigin();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Конфигарация CORS.
     */
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.setAlwaysUseFullPath(true);
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * {@see AccessDeniedHandler}.
     */
    private AccessDeniedHandler accessDeniedHandler() {
        ErrorDescription errorDescription = ErrorDescription.ACCESS_DENIED;
        ApplicationErrorDto error = ApplicationErrorDto.of(errorDescription.getType(), errorDescription.getCode(),
                errorDescription.getMessage());
        return (request, response, ex) -> HttpResponseUtils.writeError(response, error,
                HttpServletResponse.SC_FORBIDDEN);
    }

    /**
     * {@see AuthenticationEntryPoint}.
     */
    private AuthenticationEntryPoint authenticationEntryPoint() {
        ErrorDescription errorDescription = ErrorDescription.UNAUTHORIZED_ACCESS;
        ApplicationErrorDto error = ApplicationErrorDto.of(errorDescription.getType(), errorDescription.getCode(),
                errorDescription.getMessage());
        return (request, response, ex) -> HttpResponseUtils.writeError(response, error,
                HttpServletResponse.SC_UNAUTHORIZED);
    }

    private static final String[] AUTH_WHITELIST = {
            "/authenticate",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/webjars/**"
    };

}
