package br.com.igopereira1.exchangerateapi.service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import io.github.cdimascio.dotenv.Dotenv;

public class ExchangeRateApi {
    private static final String API_KEY = Dotenv.load().get("API_KEY");
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static HttpResponse<String> getExchangeRatesJSON(String choice) throws IOException, InterruptedException {

        String address = BASE_URL + API_KEY + "/latest/" + choice.substring(0, 3);
        URI uri = URI.create(address);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
