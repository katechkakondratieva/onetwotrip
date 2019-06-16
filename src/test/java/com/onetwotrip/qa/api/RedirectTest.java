package com.onetwotrip.qa.api;

import com.onetwotrip.qa.utils.Configuration;
import org.apache.http.HttpResponse;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class RedirectTest extends ApiBaseTest {

    @Test
    public void checkRedirect() {
        String url = Configuration.instance().host;
        HttpResponse response = httpHelper.getWithoutRedirect(url);

        step("Assertion status code");
        assertThat(response.getStatusLine().getStatusCode()).as("Http status code").isEqualTo(301);

        String redirectUrl = response.getFirstHeader("Location").getValue();

        step("Assertions");
        assertThat(redirectUrl).as("Redirect Url").isEqualTo("https://www.onetwotrip.com/");
    }
}
