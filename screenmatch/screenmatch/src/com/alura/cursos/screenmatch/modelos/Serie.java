package com.alura.cursos.screenmatch.modelos;

public class Serie extends Titulo {
    int temporadas;
    int espisodiosPorTemporada;
    int minutosPorTemporadas;

    public Serie(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public int getDuracionEnMinutos(){
        return temporadas*espisodiosPorTemporada*minutosPorTemporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEspisodiosPorTemporada() {
        return espisodiosPorTemporada;
    }

    public void setEspisodiosPorTemporada(int espisodiosPorTemporada) {
        this.espisodiosPorTemporada = espisodiosPorTemporada;
    }

    public int getMinutosPorTemporadas() {
        return minutosPorTemporadas;
    }

    public void setMinutosPorTemporadas(int minutosPorTemporadas) {
        this.minutosPorTemporadas = minutosPorTemporadas;
    }

    @Override
    public String toString() {
        return "Serie"+this.getNombre()+"("+this.getFechaDeLanzamiento()+")";
    }
}

