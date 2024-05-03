package br.com.igopereira1.exchangerateapi.service;
import br.com.igopereira1.exchangerateapi.model.CurrencyData;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CurrencyJsonMapper {
    public static CurrencyData jsonToJava(String json) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        return gson.fromJson(json, CurrencyData.class);
    }
}
