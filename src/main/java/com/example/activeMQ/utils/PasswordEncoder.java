package com.example.activeMQ.utils;

import lombok.experimental.UtilityClass;

import java.util.Base64;

@UtilityClass
public class PasswordEncoder {

    public String decode(String passwordEncoded) {
        return new String(Base64.getDecoder().decode(passwordEncoded));
    }

}
