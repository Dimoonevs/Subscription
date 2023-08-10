package com.example.subscribing.domain.exception;

import com.example.subscribing.domain.exception.Code.Code;

public class Error {
    private Code code;
    private String message;

    public Error(Code code, String message) {
        this.code = code;
        this.message = message;
    }


    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
