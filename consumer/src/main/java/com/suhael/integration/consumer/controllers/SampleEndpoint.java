package com.suhael.integration.consumer.controllers;

import com.suhael.integration.consumer.service.HelloWorldService;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;

@MessageEndpoint
public class SampleEndpoint {

    private final HelloWorldService helloWorldService;

    public SampleEndpoint(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @ServiceActivator
    public String hello(File input) throws Exception {
        FileInputStream in = new FileInputStream(input);
        String name = new String(StreamUtils.copyToByteArray(in));
        in.close();
        System.out.println("IM in Sample Endpoint");
        return this.helloWorldService.getHelloMessage(name);
    }

}