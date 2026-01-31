package com.sales.savvy;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.sales.savvy.repository.UserRepository;
import com.sales.savvy.security.JWTAuthenticationFilter;
import com.sales.savvy.security.JwtAuthenticationEntryPoint;
import com.sales.savvy.service.UserService;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    private final CorsConfigurationSource corsConfigurationSource;

    WebConfig webConfig = new WebConfig();
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JWTAuthenticationFilter filter;
    @Autowired
	private UserService userService;
    SecurityConfig(CorsConfigurationSource corsConfigurationSource, UserRepository userRepository) {
        this.corsConfigurationSource = corsConfigurationSource;
        this.userRepository = userRepository;
    }
	@Bean
	public JWTAuthenticationFilter jwtAuthFilter() {
		return new JWTAuthenticationFilter();
	}
    // Reduced whitelist for simplicity
    private static final String[] WHITE_LIST_URL = {
    		"/api/user/signUp", "/api/user/signIn"
    };
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(autherizeRequests -> autherizeRequests
        		.requestMatchers("/h2-console/**").permitAll()
        		.requestMatchers(HttpMethod.GET, "/api/orders/test").permitAll()
        		.requestMatchers(HttpMethod.POST, "/api/user/signUp").permitAll()
        		.requestMatchers(HttpMethod.POST, "/api/user/signIn").permitAll()
        		.anyRequest().authenticated());   
        http.sessionManagement(
        		session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(point));
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));
        http
        .cors(cors -> cors.configurationSource(webConfig.corsConfigurationSource()))
        .csrf(csrf -> csrf.disable());
        http.authenticationProvider(authenticationProvider(userDetailsService()));
        http.addFilterBefore(jwtAuthFilter(),UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public UserDetailsService userDetailsService() {
    	return userService;
    }


}