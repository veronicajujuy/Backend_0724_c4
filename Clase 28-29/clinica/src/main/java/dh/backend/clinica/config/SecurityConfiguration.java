package dh.backend.clinica.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                auth ->{
                    // endpoints que no necesitan autenticacion
                    auth.requestMatchers("/api/auth/**").permitAll();
                    auth.requestMatchers("/h2-console/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/odontologo/**").permitAll();
                    // endponints que necesitan algun tipo de rol especifico
                    auth.requestMatchers(HttpMethod.POST,"/odontologo/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT,"/odontologo/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE,"/odontologo/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers("/paciente/**").hasAnyAuthority("ADMIN");

                    // endpoints que requieren autenticacion basica (tener al menos el rol de user)
                    auth.requestMatchers("/turnos/**").authenticated();
                    auth.anyRequest().authenticated();

                })
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }
}
