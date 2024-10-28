package com.alura.cursos.screenmatch.principal;

import com.alura.cursos.screenmatch.excepcion.ErrorEnConversionException;
import com.alura.cursos.screenmatch.modelos.Titulo;
import com.alura.cursos.screenmatch.modelos.TituloOmDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura=new Scanner(System.in);
        List<Titulo>titulos=new ArrayList<>();
        Gson gson=new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("Escriba el nombre de la pelicula");
            var busqueda=lectura.nextLine();


            if (busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String direccion="http://www.omdbapi.com/?t="+busqueda.replace(" ","+")+"&apikey=4a968531";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request,  HttpResponse.BodyHandlers.ofString());


                String json=response.body();
                System.out.println(response.body());


                TituloOmDB miTituloOmDB = gson.fromJson(json, TituloOmDB.class);
                System.out.println(miTituloOmDB);

                Titulo miTitulo = new Titulo(miTituloOmDB);
                System.out.println("Titulo ya convertido: "+miTitulo);

                titulos.add(miTitulo);


            }catch (NumberFormatException e){
                System.out.println("Ocurrio un Error");
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Error en la uri");
            }catch (ErrorEnConversionException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escritura=new FileWriter("titulos.txt");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        System.out.println("Finalizo la ejecucion");
    }
}
