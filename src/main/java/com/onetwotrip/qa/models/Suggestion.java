package com.onetwotrip.qa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggestion {
    @NonNull @JsonProperty("id") private float id;
    @NonNull @JsonProperty("city_id") private float cityId;
    @NonNull @JsonProperty("type") private String type;
    @NonNull @JsonProperty("country_code") private String countryCode;
    @NonNull @JsonProperty("rel") private float rel;
}
