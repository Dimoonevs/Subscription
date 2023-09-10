package com.example.subscribing.configuration;

import com.example.subscribing.domain.UserDetailsImpl;
import com.example.subscribing.dto.module.Coach;
import com.example.subscribing.dto.repository.CoachRepo;
import com.example.subscribing.service.impl.SecurityKeyGenerateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class AppConfig {
    private final CoachRepo coachRepo;

//    @Autowired
    public AppConfig(CoachRepo coachRepo) {
        this.coachRepo = coachRepo;
    }

    @Bean
    public SecureRandom secureRandom(){
        return new SecureRandom();
    }

    @Bean
    public SecurityKeyGenerateImpl securityKeyGenerate(SecureRandom secureRandom){
        return new SecurityKeyGenerateImpl(secureRandom);
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
                Coach coach = coachRepo.findByLogin(login).get();
                UserDetailsImpl userDetails = new UserDetailsImpl();
                userDetails.setCoach(coach);
                return userDetails;
            }
        };
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
            return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
