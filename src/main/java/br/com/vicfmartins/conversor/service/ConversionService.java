package br.com.vicfmartins.conversor.service;

import br.com.vicfmartins.conversor.model.ConversionRecord;
import br.com.vicfmartins.conversor.model.ExchangeRateApiResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ConversionService {

    private final ExchangeRateService exchangeRateService;
    private final List<ConversionRecord> history = new ArrayList<>();

    public ConversionService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public ConversionRecord convert(String baseCurrency, String targetCurrency, BigDecimal amount) {
        validateAmount(amount);

        String base = normalizeCode(baseCurrency);
        String target = normalizeCode(targetCurrency);

        ExchangeRateApiResponse response = exchangeRateService.fetchRates(base);
        Map<String, BigDecimal> rates = response.conversionRates();

        if (rates == null || !rates.containsKey(target)) {
            throw new IllegalArgumentException("A moeda de destino informada nao foi encontrada na API.");
        }

        BigDecimal rate = rates.get(target);
        BigDecimal convertedAmount = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);

        ConversionRecord record = new ConversionRecord(
                base,
                target,
                amount.setScale(2, RoundingMode.HALF_UP),
                convertedAmount,
                rate.setScale(4, RoundingMode.HALF_UP),
                LocalDateTime.now()
        );

        history.add(record);
        return record;
    }

    public List<ConversionRecord> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("O valor da conversao nao pode ser nulo.");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da conversao deve ser maior que zero.");
        }
    }

    private String normalizeCode(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("O codigo da moeda nao pode ser vazio.");
        }

        return code.trim().toUpperCase(Locale.ROOT);
    }
}
