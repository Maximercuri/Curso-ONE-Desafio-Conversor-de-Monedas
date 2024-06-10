package com.aluraCursos.conversorMonedas.modelos;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeDivisas {
    public void convertir(String divisaInicial, String divisaConvertida, double monto){

        Gson converter = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            URI url = URI
                    .create("https://v6.exchangerate-api.com/v6/92016e8ba546867176f4d700/pair/" + divisaInicial.toUpperCase() + "/" + divisaConvertida.toUpperCase() + "/" + monto);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JsonElement jsonElement = JsonParser.parseString(json);

            JsonObject jsonObject = jsonElement.getAsJsonObject();

            System.out.println(monto + " " + divisaInicial.toUpperCase() + " es equivalente a " +  jsonObject.get("conversion_result") + " " + divisaConvertida.toUpperCase() + " al cambio actual del dia: " + jsonObject.get("time_last_update_utc"));

        } catch (NumberFormatException e) {
            System.out.println("Formato de numero de monto equivocado, intentalo de nuevo: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la dirección (posiblemente los códigos de divisa sean incorrectos).");
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error inesperado: " + e);
        }
    }
}
