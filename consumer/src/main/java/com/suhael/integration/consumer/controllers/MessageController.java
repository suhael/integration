package com.suhael.integration.consumer.controllers;

import com.suhael.integration.consumer.service.AddressService;
import com.suhael.integration.consumer.service.SampleMessageGateway;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/rest/message", produces = APPLICATION_JSON_VALUE)
public class MessageController {

    private final SampleMessageGateway gateway;

    public MessageController(SampleMessageGateway gateway) {
        this.gateway = gateway;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAddress(@RequestBody String msg) {
        gateway.echo(msg);
    }

}
