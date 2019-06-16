package com.onetwotrip.qa.services;

import com.onetwotrip.qa.utils.http.HttpHelper;

public class BaseService {

    public String getRout() {
        return rout;
    }

    protected HttpHelper httpHelper;
    protected String rout;

    public BaseService(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }
}
