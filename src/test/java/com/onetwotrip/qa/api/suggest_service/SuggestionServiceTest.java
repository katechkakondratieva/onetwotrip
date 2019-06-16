package com.onetwotrip.qa.api.suggest_service;

import com.onetwotrip.qa.api.ApiBaseTest;
import com.onetwotrip.qa.models.GetSuggestionsResponse;
import org.apache.http.HttpResponse;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;


public class SuggestionServiceTest extends ApiBaseTest {

    @Test
    public void getSuggestions() throws IOException {
        HttpResponse response = suggestService.getSuggestions("Barcelona", null,null,null, null);

        step("Assertion status code");
        assertThat(response.getStatusLine().getStatusCode()).as("Http status code").isEqualTo(200);

        String body = httpHelper.getResponseBody(response);
        GetSuggestionsResponse getSuggestionsResponse = this.mapper.readValue(body, GetSuggestionsResponse.class);

        step("Assertions");
        assertThat(getSuggestionsResponse).isNotNull();
        assertThat(getSuggestionsResponse.getError()).isNull();
        assertThat(getSuggestionsResponse.getResult().size()).isGreaterThan(0);
    }
}

