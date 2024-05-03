package br.com.igopereira1.exchangerateapi.model;
import java.util.Map;

public record CurrencyData (Map<String, Double> conversionRates) {
}
