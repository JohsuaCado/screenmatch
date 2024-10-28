package com.alura.cursos.screenmatch.modelos;

import com.alura.cursos.screenmatch.excepcion.ErrorEnConversionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnELPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmDB miTituloOmDB) throws ErrorEnConversionException {
        this.nombre=miTituloOmDB.title();
        this.fechaDeLanzamiento= Integer.valueOf(miTituloOmDB.year());
        if (miTituloOmDB.runtime().contains("N/A")){
            throw new ErrorEnConversionException("No se pudo convertir  la duracion, ya "
            +"que contiee un N/A");
        }
        this.duracionEnMinutos=Integer.valueOf(miTituloOmDB.runtime().substring(0,3).replace(" ", ""));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnELPlan() {
        return incluidoEnELPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnELPlan(boolean incluidoEnELPlan) {
        this.incluidoEnELPlan = incluidoEnELPlan;
    }

    public int getTotalDeLasEvaluaciones(){
        return totalDeLasEvaluaciones;
    }
    public void muestraFichaTecnica(){
        System.out.println("La pelicula es: "+nombre);
        System.out.println("Fecha de Lanzamiento: " +fechaDeLanzamiento);
        System.out.println("Duracion en Minutos: "+getDuracionEnMinutos());
    };
    public void evalua(double nota){
        sumaDeLasEvaluaciones +=nota;
        totalDeLasEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre=" + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento+
                ", Duracion: "+duracionEnMinutos+")";
    }
}
