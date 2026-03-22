package br.com.vicfmartins.conversor.util;

import br.com.vicfmartins.conversor.model.ConversionRecord;

import java.time.format.DateTimeFormatter;

public final class ConsoleFormatter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private ConsoleFormatter() {
    }

    public static void printConversion(ConversionRecord record) {
        System.out.println();
        System.out.println("Resultado da conversao");
        System.out.println(record.originalAmount() + " " + record.baseCurrency()
                + " = " + record.convertedAmount() + " " + record.targetCurrency());
        System.out.println("Taxa utilizada: 1 " + record.baseCurrency()
                + " = " + record.rate() + " " + record.targetCurrency());
        System.out.println("Data: " + record.timestamp().format(DATE_TIME_FORMATTER));
    }

    public static void printHistoryLine(ConversionRecord record) {
        System.out.println("- " + record.timestamp().format(DATE_TIME_FORMATTER)
                + " | " + record.originalAmount() + " " + record.baseCurrency()
                + " -> " + record.convertedAmount() + " " + record.targetCurrency()
                + " | taxa " + record.rate());
    }
}
