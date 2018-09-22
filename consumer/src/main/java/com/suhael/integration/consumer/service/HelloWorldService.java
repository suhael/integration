package com.suhael.integration.consumer.service;

import com.suhael.integration.consumer.config.ServiceProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private final ServiceProperties configuration;

    @Autowired
    public HelloWorldService(ServiceProperties configuration) {
        this.configuration = configuration;
    }

    public String getHelloMessage(String name) {
        System.out.println("I'm in hellow world service");
        return this.configuration.getGreeting() + " " + name;
    }

}