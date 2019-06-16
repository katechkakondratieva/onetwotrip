package com.onetwotrip.qa.utils.http;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpHelper {
    private HttpClient client;
    private HttpClient clientWithoutRedirect;


    public HttpHelper() {
        this.client = HttpClientBuilder.create().build();
        this.clientWithoutRedirect = HttpClientBuilder.create().disableRedirectHandling().build();
    }

    private static class HttpHelperHolder {
        static final HttpHelper HOLDER = new HttpHelper();
    }

    public static HttpHelper instance() {
        return HttpHelperHolder.HOLDER;
    }

    @Step("Get Request")
    @Attachment("HttpResponse")
    public HttpResponse get(@NonNull String url) {
        try {
            HttpGet get = new HttpGet(url);
            return this.client.execute(get);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Step("Get Request without redirect")
    @Attachment("HttpResponse")
    public HttpResponse getWithoutRedirect(@NonNull String url) {
        try {
            HttpGet get = new HttpGet(url);
            return this.clientWithoutRedirect.execute(get);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Attachment("ResponseBody")
    public String getResponseBody(HttpResponse response) {
        try {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
