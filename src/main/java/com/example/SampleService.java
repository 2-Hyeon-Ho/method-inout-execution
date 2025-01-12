package com.example;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @LogExecution
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @LogExecution
    public int add(int a, int b) {
        return a+b;
    }
}
