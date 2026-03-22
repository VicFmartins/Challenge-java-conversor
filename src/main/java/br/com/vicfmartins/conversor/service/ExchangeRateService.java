package br.com.vicfmartins.conversor.service;

import br.com.vicfmartins.conversor.config.ApiConfig;
import br.com.vicfmartins.conversor.model.ExchangeRateApiResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class ExchangeRateService {

    private final HttpClient httpClient;
    private final Gson gson;

    public ExchangeRateService() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ExchangeRateApiResponse fetchRates(String baseCurrency) {
        String normalizedBase = normalizeCurrencyCode(baseCurrency);
        String encodedBase = URLEncoder.encode(normalizedBase, StandardCharsets.UTF_8);
        String url = ApiConfig.BASE_URL + "/" + ApiConfig.getApiKey() + "/latest/" + encodedBase;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IllegalStateException("Falha ao consultar a API. HTTP " + response.statusCode() + ".");
            }

            ExchangeRateApiResponse apiResponse = gson.fromJson(response.body(), ExchangeRateApiResponse.class);

            if (apiResponse == null) {
                throw new IllegalStateException("Resposta vazia da API.");
            }

            if (!"success".equalsIgnoreCase(apiResponse.result())) {
                String apiError = apiResponse.errorType() == null ? "erro_desconhecido" : apiResponse.errorType();
                throw new IllegalStateException("A API retornou erro: " + apiError + ".");
            }

            return apiResponse;
        } catch (IOException e) {
            throw new IllegalStateException("Falha de comunicacao com a API de cambio.", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("A requisicao foi interrompida.", e);
        }
    }

    private String normalizeCurrencyCode(String currencyCode) {
        if (currencyCode == null || currencyCode.isBlank()) {
            throw new IllegalArgumentException("O codigo da moeda nao pode ser vazio.");
        }

        return currencyCode.trim().toUpperCase(Locale.ROOT);
    }
}
