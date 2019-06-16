package com.onetwotrip.qa.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onetwotrip.qa.services.suggest.SuggestService;
import com.onetwotrip.qa.utils.http.HttpHelper;

public abstract class ApiBaseTest {

    protected final HttpHelper httpHelper;
    protected final SuggestService suggestService;
    protected final ObjectMapper mapper;

    protected ApiBaseTest() {
        this.httpHelper = HttpHelper.instance();
        this.suggestService = new SuggestService(httpHelper);
        this.mapper = new ObjectMapper();
    }
}
