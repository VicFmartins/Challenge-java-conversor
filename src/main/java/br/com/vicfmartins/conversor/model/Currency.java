package br.com.vicfmartins.conversor.model;

public enum Currency {
    USD("Dolar Americano"),
    BRL("Real Brasileiro"),
    EUR("Euro"),
    GBP("Libra Esterlina"),
    JPY("Iene Japones"),
    ARS("Peso Argentino"),
    COP("Peso Colombiano");

    private final String description;

    Currency(String description) {
        this.description = description;
    }

    public String getCode() {
        return name();
    }

    public String getDescription() {
        return description;
    }
}
