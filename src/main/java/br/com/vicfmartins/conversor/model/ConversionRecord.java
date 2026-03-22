package br.com.vicfmartins.conversor.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConversionRecord(
        String baseCurrency,
        String targetCurrency,
        BigDecimal originalAmount,
        BigDecimal convertedAmount,
        BigDecimal rate,
        LocalDateTime timestamp
) {
}
