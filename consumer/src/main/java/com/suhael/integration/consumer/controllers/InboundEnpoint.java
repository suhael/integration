package com.suhael.integration.consumer.controllers;

import com.suhael.integration.consumer.models.Customer;
import com.suhael.integration.consumer.service.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.Resource;

@Component
public class InboundEnpoint {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Resource
    CustomerService custService;

    public Message<?> get(Message<?> msg) {
        log.info("GET method");
        List<Customer> custLst = custService.getAll();
        return MessageBuilder.withPayload(custLst).copyHeadersIfAbsent(msg.getHeaders())
                .setHeader("http_statusCode", HttpStatus.OK).build();
    }

    public void post(Message<Customer> msg){
        log.info("POST method");
        custService.insert(msg.getPayload());
    }

    public void put(Message<Customer> msg){
        log.info("PUT method");
        custService.change(msg.getPayload());
    }

    public void delete(Message<String>msg){
        log.info("DELETE method");
        int id = Integer.valueOf(msg.getPayload());
        custService.delete(id);
    }
}