package br.com.vicfmartins.conversor.ui;

import br.com.vicfmartins.conversor.model.ConversionRecord;
import br.com.vicfmartins.conversor.model.Currency;
import br.com.vicfmartins.conversor.service.ConversionService;
import br.com.vicfmartins.conversor.util.ConsoleFormatter;
import br.com.vicfmartins.conversor.util.InputReader;

import java.math.BigDecimal;
import java.util.List;

public class ConsoleMenu {

    private final ConversionService conversionService;

    public ConsoleMenu(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public void start() {
        try (InputReader inputReader = new InputReader()) {
            int option;

            do {
                printMenu();
                option = inputReader.readInt("Escolha uma opcao: ");
                handleOption(option, inputReader);
            } while (option != 0);
        }
    }

    private void handleOption(int option, InputReader inputReader) {
        try {
            switch (option) {
                case 1 -> quickConversion("USD", "BRL", inputReader);
                case 2 -> quickConversion("BRL", "USD", inputReader);
                case 3 -> quickConversion("USD", "EUR", inputReader);
                case 4 -> quickConversion("EUR", "USD", inputReader);
                case 5 -> quickConversion("USD", "ARS", inputReader);
                case 6 -> quickConversion("ARS", "USD", inputReader);
                case 7 -> customConversion(inputReader);
                case 8 -> printHistory();
                case 9 -> printSupportedCurrencies();
                case 0 -> System.out.println("Encerrando o conversor.");
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }
        } catch (RuntimeException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private void quickConversion(String base, String target, InputReader inputReader) {
        BigDecimal amount = inputReader.readBigDecimal("Digite o valor a converter: ");
        ConversionRecord record = conversionService.convert(base, target, amount);
        ConsoleFormatter.printConversion(record);
    }

    private void customConversion(InputReader inputReader) {
        String base = inputReader.readText("Informe a moeda de origem (ex.: USD): ");
        String target = inputReader.readText("Informe a moeda de destino (ex.: BRL): ");
        BigDecimal amount = inputReader.readBigDecimal("Digite o valor a converter: ");

        ConversionRecord record = conversionService.convert(base, target, amount);
        ConsoleFormatter.printConversion(record);
    }

    private void printHistory() {
        if (!conversionService.hasHistory()) {
            System.out.println("Nenhuma conversao realizada nesta sessao.");
            return;
        }

        List<ConversionRecord> history = conversionService.getHistory();
        System.out.println("Historico de conversoes:");
        history.forEach(ConsoleFormatter::printHistoryLine);
    }

    private void printSupportedCurrencies() {
        System.out.println("Moedas do menu rapido:");
        for (Currency currency : Currency.values()) {
            System.out.println("- " + currency.getCode() + " | " + currency.getDescription());
        }
        System.out.println("Na conversao personalizada, outros codigos suportados pela API tambem podem ser usados.");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("         CONVERSOR DE MOEDAS");
        System.out.println("========================================");
        System.out.println("1. USD -> BRL");
        System.out.println("2. BRL -> USD");
        System.out.println("3. USD -> EUR");
        System.out.println("4. EUR -> USD");
        System.out.println("5. USD -> ARS");
        System.out.println("6. ARS -> USD");
        System.out.println("7. Conversao personalizada");
        System.out.println("8. Ver historico");
        System.out.println("9. Ver moedas do menu rapido");
        System.out.println("0. Sair");
        System.out.println("========================================");
    }
}
