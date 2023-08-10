package com.example.subscribing;

import com.example.subscribing.dto.module.Coach;
import com.example.subscribing.dto.repository.CoachRepo;
import com.example.subscribing.service.impl.AuthServiceImpl;
import com.example.subscribing.service.impl.SecurityKeyGenerateImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@SpringBootApplication
public class SubscribingApplication {


	public static void main(String[] args) {
		SpringApplication.run(SubscribingApplication.class, args);
	}

}
