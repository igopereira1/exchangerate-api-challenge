package br.com.igopereira1.exchangerateapi.model;

public class CurrencyConverter {
    private final Double amount;
    private final CurrencyData currencyData;

    public CurrencyConverter(Double amount, CurrencyData currencyData) {
        this.amount = amount;
        this.currencyData = currencyData;
    }

    public double convertCurrency(String inputCurrency, String outputCurrency) {
        return amount * currencyData.conversionRates().get(outputCurrency) / currencyData.conversionRates().get(inputCurrency);
    }
}
