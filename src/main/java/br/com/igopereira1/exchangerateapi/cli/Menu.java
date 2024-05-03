package br.com.igopereira1.exchangerateapi.cli;
import java.util.Scanner;

public class Menu {
    public static String showMenu() {
        System.out.println("Digite 1 para converter Dólar Americano x Real Brasileiro");
        System.out.println("Digite 2 para converter Dólar Americano x Peso Argentino");
        System.out.println("Digite 3 para converter Dólar Americano x Pesos Colombianos");
        System.out.println("Digite 4 para converter Real Brasileiro x Dólar Americano");
        System.out.println("Digite 5 para converter Pesos Colombianos x Dólar Americano");
        System.out.println("Digite 6 para converter Pesos Argentinos x Dólar Americano");
        System.out.println("Digite 7 para fazer uma conversão personalizada");
        System.out.println("Digite 8 para sair");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> "USDtoBRL";
            case 2 -> "USDtoARS";
            case 3 -> "USDtoCOP";
            case 4 -> "BRLtoUSD";
            case 5 -> "COPtoUSD";
            case 6 -> "ARStoUSD";
            case 7 -> customConversionMenu();
            case 8 -> "break";
            default -> {
                System.out.println("Opção inválida! Tente novamente.");
                yield showMenu();
            }
        };
    }

    private static String customConversionMenu() {
        System.out.println("Digite a moeda de origem: ");
        System.out.println("Dentre as opções estão: USD, BRL, ARS, COP, EUR, GBP, JPY, CHF, AUD, CAD, CNY, HKD, INR, KRW, MXN, NOK, NZD, SEK, SGD, ZAR");
        Scanner scanner = new Scanner(System.in);
        String inputCurrency = scanner.nextLine();
        System.out.println("Digite a moeda de destino: ");
        String outputCurrency = scanner.nextLine();
        return inputCurrency.toUpperCase() + "to" + outputCurrency.toUpperCase();
    }
}
