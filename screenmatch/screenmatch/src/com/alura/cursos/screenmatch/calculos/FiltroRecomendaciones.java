package com.alura.cursos.screenmatch.calculos;

public class FiltroRecomendaciones {
    public void filtra(Clasificacion clasificacion){
        if (clasificacion.getClasificacion()>=4){
            System.out.println("Muy recomendable");
        }else if (clasificacion.getClasificacion()>=2){
            System.out.println("Un clasico");
        }else {
            System.out.println("Para tener tiempo");
        }
    }
}
