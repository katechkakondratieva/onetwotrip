package com.onetwotrip.qa.services.suggest;

import com.onetwotrip.qa.services.BaseService;
import com.onetwotrip.qa.utils.Configuration;
import com.onetwotrip.qa.utils.http.HttpHelper;

import io.qameta.allure.Step;
import lombok.NonNull;
import org.apache.http.HttpResponse;

public class SuggestService extends BaseService {


    public SuggestService(HttpHelper httpHelper) {
        super(httpHelper);
        rout = String.format("%s/_hotels/api/suggestRequest", Configuration.instance().host);
    }
    @Step("SuggestService getSuggestions")
    public HttpResponse getSuggestions(@NonNull String query, String limit, String lang, String locale, String currency){
        String url = rout + "?query=" + query;
        if (limit != null) url += "&limit=" + limit;
        if (lang != null) url += "&lang=" + lang;
        if (locale != null) url += "&locale=" + locale;
        if (currency != null) url += "&currency=" + currency;
        return HttpHelper.instance().get(url);
    }
}
