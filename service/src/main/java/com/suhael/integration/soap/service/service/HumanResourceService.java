package com.suhael.integration.soap.service.service;

import java.util.Date;

public interface HumanResourceService {

    void bookHoliday(Date startDate, Date endDate, String name);

}