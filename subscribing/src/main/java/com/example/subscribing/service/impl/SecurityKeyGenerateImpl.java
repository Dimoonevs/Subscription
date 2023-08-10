package com.example.subscribing.service.impl;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class SecurityKeyGenerateImpl {
    private SecureRandom secureRandom;

    public SecurityKeyGenerateImpl(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    public SecurityKeyGenerateImpl() {
    }

    public Long generateRandomKey() {
        return this.secureRandom.nextLong();
    }
}
