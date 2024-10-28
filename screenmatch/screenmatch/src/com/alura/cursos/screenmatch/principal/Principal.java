package com.alura.cursos.screenmatch.principal;

import com.alura.cursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.alura.cursos.screenmatch.calculos.FiltroRecomendaciones;
import com.alura.cursos.screenmatch.modelos.Episodios;
import com.alura.cursos.screenmatch.modelos.Pelicula;
import com.alura.cursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula=new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnELPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(7.8);
        miPelicula.evalua(10);

        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie casaDragon=new Serie("La casa del dragon",2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorTemporadas(50);
        casaDragon.setEspisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();

        Pelicula otraPelicula=new com.alura.cursos.screenmatch.modelos.Pelicula("Matrix",1998);
        otraPelicula.setDuracionEnMinutos(180);

        CalculadoraDeTiempo calculadoraDeTiempo=new CalculadoraDeTiempo();
        calculadoraDeTiempo.incluye(miPelicula);
        calculadoraDeTiempo.incluye(casaDragon);
        calculadoraDeTiempo.incluye(otraPelicula);
        System.out.println("Tiempo Total para ver tu lista en vaca: " +calculadoraDeTiempo.getTiempoTotal()+"mins" );

        FiltroRecomendaciones filtroRecomendaciones=new FiltroRecomendaciones();
        filtroRecomendaciones.filtra(miPelicula );

        Episodios episodios=new Episodios();
        episodios.setNumero(1);
        episodios.setNombre("La Casa del Dragon");
        episodios.setSerie(casaDragon);
        episodios.setTotalDeVisualizaciones(50);
        filtroRecomendaciones.filtra(episodios);

        var peliculaDeBruno =new Pelicula("El Señor de los anillos", 180);
        peliculaDeBruno.setFechaDeLanzamiento(2001);

        ArrayList<Pelicula>listaDePeliculas=new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(peliculaDeBruno);

        System.out.println(listaDePeliculas.get(0).toString());

    }
}
