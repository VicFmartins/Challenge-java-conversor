package br.com.vicfmartins.conversor.config;

public final class ApiConfig {

    public static final String ENV_API_KEY = "EXCHANGE_RATE_API_KEY";
    public static final String BASE_URL = "https://v6.exchangerate-api.com/v6";

    private ApiConfig() {
    }

    public static String getApiKey() {
        String apiKey = System.getenv(ENV_API_KEY);

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "A variavel de ambiente EXCHANGE_RATE_API_KEY nao foi definida."
            );
        }

        return apiKey;
    }
}
