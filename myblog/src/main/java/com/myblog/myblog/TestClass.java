package com.myblog.myblog;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestClass {

    public static void main(String[] args) {

        new BCryptPasswordEncoder();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("Testing"));
    }
}
