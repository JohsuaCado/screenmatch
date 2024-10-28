package com.alura.cursos.screenmatch.calculos;

import com.alura.cursos.screenmatch.modelos.Pelicula;
import com.alura.cursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public  void incluye(Titulo titulo){
        this.tiempoTotal+=titulo.getDuracionEnMinutos();
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
}
