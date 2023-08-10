package com.example.subscribing.domain.reponse;

public class CachingLoginResp {
    private String token;

    public CachingLoginResp(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
