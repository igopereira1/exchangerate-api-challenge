package br.com.igopereira1.exchangerateapi.main;
import br.com.igopereira1.exchangerateapi.service.CurrencyConversion;

public class Main {
    public static void main(String[] args) {
        CurrencyConversion service = new CurrencyConversion();
        service.run();
    }
}
