package main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import models.Moneda;

public class ConnectionAPI {

    public Moneda SearchCoins(String monedaBaseTxt, String monedaCambioTxt){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/2e7b97e2df274910b8ebe0fa/pair/"+monedaBaseTxt+"/"+monedaCambioTxt);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(url)
                                         .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }
        catch(Exception e){
            throw new RuntimeException("Moneda no encontrada");
        }
    }

}
