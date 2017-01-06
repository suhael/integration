package com.suhael.integration.client.controller;

import com.suhael.integration.client.service.SoapClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.datatype.DatatypeConfigurationException;

@RestController
@RequestMapping("/person")
public class Requestcontroller {

    @Autowired
    private SoapClient soapClient;

    @RequestMapping(method = RequestMethod.POST)
    public String makeRequest() throws DatatypeConfigurationException {
        soapClient.makeRequest();
        return "done";
    }

}
