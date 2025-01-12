package com.example;

import org.springframework.stereotype.Service;

@Service
public class NotLoggingService {

    public String paw(String name) {
        return name + " paw!";
    }

    public int multiple(int a, int b) {
        return a*b;
    }
}
