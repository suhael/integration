package com.suhael.integration.client.service;

import com.suhael.integration.service.jaxb.EmployeeType;
import com.suhael.integration.service.jaxb.HolidayRequest;
import com.suhael.integration.service.jaxb.HolidayType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class SoapClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(SoapClient.class);

    public void makeRequest() throws DatatypeConfigurationException {
        HolidayType holiday = new HolidayType();
        holiday.setEndDate(getXMLGregorianCalendarNow());
        holiday.setStartDate(getXMLGregorianCalendarNow());

        EmployeeType employee = new EmployeeType();
        employee.setNumber(new BigInteger("123"));
        employee.setFirstName("suhael");
        employee.setLastName("akhtar");

        HolidayRequest holidayRequest = new HolidayRequest();
        holidayRequest.setHoliday(holiday);
        holidayRequest.setEmployee(employee);


        Object response = getWebServiceTemplate().marshalSendAndReceive(holidayRequest);
    }

    public XMLGregorianCalendar getXMLGregorianCalendarNow()
            throws DatatypeConfigurationException
    {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now =
                datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }
}
