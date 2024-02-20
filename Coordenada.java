package org.example;

public class Coordenada {

    private int fila;

    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isValida(int dimension){

        boolean esValida=true;

        if (fila>dimension || columna >dimension){
            esValida=false;
        } else if (fila<1 || columna<1) {
            esValida=false;
        }
        return esValida;
    }
}