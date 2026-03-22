package br.com.vicfmartins.conversor.util;

import java.io.Closeable;
import java.math.BigDecimal;
import java.util.Scanner;

public class InputReader implements Closeable {

    private final Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();

            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    public BigDecimal readBigDecimal(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim().replace(",", ".");

            try {
                return new BigDecimal(value);
            } catch (NumberFormatException ex) {
                System.out.println("Digite um valor numerico valido.");
            }
        }
    }

    public String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isBlank()) {
                return value;
            }

            System.out.println("Este campo nao pode ficar vazio.");
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}
