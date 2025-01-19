package com.aluracursos.challenge.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {
    public TasasDeCambio buscaTasasDeCambio(String monedaBase){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/17ba1bd2a1f78247940b1297/latest/" + monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TasasDeCambio.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda base: " + monedaBase);
        }
    }
}
