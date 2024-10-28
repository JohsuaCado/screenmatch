package com.alura.cursos.screenmatch.principal;

import com.alura.cursos.screenmatch.modelos.Pelicula;
import com.alura.cursos.screenmatch.modelos.Serie;
import com.alura.cursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula=new Pelicula("Encanto", 2021);
        Pelicula otraPelicula=new com.alura.cursos.screenmatch.modelos.Pelicula("Matrix",1998);
        var peliculaDeBruno =new Pelicula("El Señor de los anillos", 180);
        Serie casaDragon=new Serie("La casa del dragon",2022);

        ArrayList<Titulo> lista=new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeBruno);
        lista.add(casaDragon);

        for (Titulo item:lista){
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion()>2){
                System.out.println(pelicula.getClasificacion());
            }
        }
        ArrayList<String>listaDeArtista=new ArrayList<>();
        listaDeArtista.add("Penelope Cruz");
        listaDeArtista.add("Antonio Banderas");
        listaDeArtista.add("Marily Monro");
        System.out.println("Lista de Artista en desorden"+listaDeArtista);
        Collections.sort(listaDeArtista);
        System.out.println("Lista de Artista en orden"+listaDeArtista);
        Collections.sort(lista);
        System.out.println("Lista de Titulos Ordenados"+lista);
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println(lista);


    }
}
