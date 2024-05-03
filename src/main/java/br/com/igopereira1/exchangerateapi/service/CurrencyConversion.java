package br.com.igopereira1.exchangerateapi.service;
import br.com.igopereira1.exchangerateapi.cli.Menu;
import br.com.igopereira1.exchangerateapi.model.CurrencyConverter;
import br.com.igopereira1.exchangerateapi.model.CurrencyData;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class CurrencyConversion {
    public void run() {
        String choice;
        CurrencyConverter currencyConverter = null;

        do {
            choice = Menu.showMenu();
            try {
                if (!choice.equals("break")) {
                    HttpResponse<String> response = ExchangeRateApi.getExchangeRatesJSON(choice);
                    CurrencyData currencyData = CurrencyJsonMapper.jsonToJava(response.body());
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Digite o valor: ");
                    double amount = scanner.nextDouble();
                    currencyConverter = new CurrencyConverter(amount, currencyData);
                    handleCurrencyConversion(choice, amount, currencyData, currencyConverter);
                }
            } catch(IOException | InterruptedException e){
                e.getMessage();
            }
        } while (!choice.equals("break"));
    }

    private void handleCurrencyConversion(String choice, double amount, CurrencyData currencyData, CurrencyConverter currencyConverter) {
        if (choice.equals("USDtoBRL") && amount > 0) {
            String inputCurrency = choice.substring(0, 3);
            String outputCurrency = choice.substring(5);
            System.out.println("Dólar Americano (USD) para Real Brasileiro (BRL)");
            System.out.println("Valor para conversão: " + "$" + amount + " dólares americanos");
            System.out.printf("$1 dólar americano equivale a R$%.4f reais\n", currencyData.conversionRates().get("BRL"));
            System.out.printf("O valor de %.2f %s em %s é: $%.2f\n", amount, inputCurrency, outputCurrency, currencyConverter.convertCurrency(inputCurrency, outputCurrency));
            System.out.println("\n");

        } else if (choice.equals("USDtoARS") && amount > 0) {
            String inputCurrency = choice.substring(0, 3);
            String outputCurrency = choice.substring(5);
            System.out.println("Dólar Americano (USD) para Peso Argentino (ARS)");
            System.out.println("Valor para conversão: " + "$" + amount + " dólares americanos");
            System.out.printf("$1 dólar americano equivale a $%.4f pesos argentinos\n", currencyData.conversionRates().get("ARS"));
            System.out.printf("O valor de %.2f %s em %s é: $%.2f\n", amount, inputCurrency, outputCurrency, currencyConverter.convertCurrency(inputCurrency, outputCurrency));
            System.out.println("\n");

        } else if (choice.equals("USDtoCOP") && amount > 0) {
            String inputCurrency = choice.substring(0, 3);
            String outputCurrency = choice.substring(5);
            System.out.println("Dólar Americano (USD) para Peso Colombiano (COP)");
            System.out.println("Valor para conversão: " + "$" + amount + " dólares americanos");
            System.out.printf("$1 dólar americano equivale a $%.4f pesos colombianos\n", currencyData.conversionRates().get("COP"));
            System.out.printf("O valor de %.2f %s em %s é: $%.2f\n", amount, inputCurrency, outputCurrency, currencyConverter.convertCurrency(inputCurrency, outputCurrency));
            System.out.println("\n");

        } else if (choice.equals("BRLtoUSD") && amount > 0) {
            String inputCurrency = choice.substring(0, 3);
            String outputCurrency = choice.substring(5);
            System.out.println("Real Brasileiro (BRL) para Dólar Americano (USD)");
            System.out.println("Valor para conversão: " + "$" + amount + " reais");
            System.out.printf("R$1 real equivale a $%.4f dólares americanos\n", currencyData.conversionRates().get("USD"));
            System.out.printf("O valor de %.2f %s em %s é: $%.2f\n", amount, inputCurrency, outputCurrency, currencyConverter.convertCurrency(inputCurrency, outputCurrency));
            System.out.println("\n");

        } else if (choice.equals("COPtoUSD") && amount > 0) {
            String inputCurrency = choice.substring(0, 3);
            String outputCurrency = choice.substring(5);
            System.out.println("Peso Colombiano (COP) para Dólar Americano (USD)");
            System.out.println("Valor para conversão: " + "$" + amount + " pesos colombianos");
            System.out.printf("$1 peso colombiano equivale a $%.4f dólares americanos\n", currencyData.conversionRates().get("USD"));
            System.out.printf("O valor de %.2f %s em %s é: $%.2f\n", amount, inputCurrency, outputCurrency, currencyConverter.convertCurrency(inputCurrency, outputCurrency));
            System.out.println("\n");

        } else if (choice.equals("ARStoUSD") && amount > 0) {
            String inputCurrency = choice.substring(0, 3);
            String outputCurrency = choice.substring(5);
            System.out.println("Peso Argentino (ARS) para Dólar Americano (USD)");
            System.out.println("Valor para conversão: " + "$" + amount + " pesos argentinos");
            System.out.printf("$1 peso argentino equivale a $%.4f dólares americanos\n", currencyData.conversionRates().get("USD"));
            System.out.printf("O valor de %.2f %s em %s é: $%.2f\n", amount, inputCurrency, outputCurrency, currencyConverter.convertCurrency(inputCurrency, outputCurrency));
            System.out.println("\n");

        } else if (choice.contains("to") && amount > 0) {
            String inputCurrency = choice.substring(0, 3);
            String outputCurrency = choice.substring(5);
            System.out.println(inputCurrency + " para " + outputCurrency);
            System.out.println("Valor para conversão: " + "$" + amount + " " + inputCurrency);
            System.out.printf("$1 %s equivale a $%.4f %s\n", inputCurrency, currencyData.conversionRates().get(outputCurrency), outputCurrency);
            System.out.printf("O valor de %.2f %s em %s é: $%.2f\n", amount, inputCurrency, outputCurrency, currencyConverter.convertCurrency(inputCurrency, outputCurrency));
            System.out.println("\n");
        }
    }
}
