package br.com.vicfmartins.conversor.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Map;

public record ExchangeRateApiResponse(
        String result,
        @SerializedName("base_code") String baseCode,
        @SerializedName("conversion_rates") Map<String, BigDecimal> conversionRates,
        @SerializedName("error-type") String errorType
) {
}
