package com.onetwotrip.qa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GetSuggestionsResponse {
    @JsonProperty("error") private String error;
    @NonNull @JsonProperty("result") private ArrayList<Suggestion> result = new ArrayList<>();
}
