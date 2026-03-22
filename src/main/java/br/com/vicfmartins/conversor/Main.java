package br.com.vicfmartins.conversor;

import br.com.vicfmartins.conversor.service.ConversionService;
import br.com.vicfmartins.conversor.service.ExchangeRateService;
import br.com.vicfmartins.conversor.ui.ConsoleMenu;

public class Main {

    public static void main(String[] args) {
        ExchangeRateService exchangeRateService = new ExchangeRateService();
        ConversionService conversionService = new ConversionService(exchangeRateService);
        ConsoleMenu consoleMenu = new ConsoleMenu(conversionService);
        consoleMenu.start();
    }
}
