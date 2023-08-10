package com.example.subscribing.service.impl;

import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.exception.Code.Code;
import com.example.subscribing.domain.exception.CommonException;
import com.example.subscribing.domain.request.CoachLoginReq;
import com.example.subscribing.dto.module.Coach;
import com.example.subscribing.dto.repository.CoachRepo;
import com.example.subscribing.service.AuthService;
import com.example.subscribing.service.jwt.JwtService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final CoachRepo coachRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Value("${coachPassword}")
    private String passwordCoach;

    @Value("${coachLogin}")
    private String loginCoach;

    public AuthServiceImpl(CoachRepo coachRepo, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.coachRepo = coachRepo;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<Response> login(CoachLoginReq coachLoginReq) {
        Coach coach = coachRepo.findByLogin(coachLoginReq.getLogin()).get();

        if (coach == null){
            throw new CommonException(Code.AUTHORIZATION_ERROR, "Ошибка авторизации, неверный логин", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        coachLoginReq.getLogin(),
                        coachLoginReq.getPassword()
                )
        );

        if (!passwordEncoder.matches(coachLoginReq.getPassword(), coach.getPassword())){
            throw  new CommonException(Code.PASSWORD_ERROR, "Неверный пароль", HttpStatus.BAD_REQUEST);
        }

        String token = jwtService.generateToken(authentication);
        Response response = new Response<>(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostConstruct
    public void saveCoach() {
        Coach coach = new Coach(loginCoach, passwordEncoder.encode(passwordCoach));
        coachRepo.save(coach);
    }
}
