package org.example;

public class Tablero {

    public static final int DIMENSION = 3;
    private EstadoCasilla[][] casillas;

    public Tablero() {

        casillas = new EstadoCasilla[DIMENSION][DIMENSION];
        vaciar();
    }
    // el bo
    public boolean hayTresEnRaya() {

        return hayTresEnRaya(EstadoCasilla.X) || hayTresEnRaya(EstadoCasilla.O);
    }

    public void mostrar() {
        System.out.println(" | 1| 2| 3|");
        for (int i = 0; i < DIMENSION; i++) {
            System.out.print(i+1+"|");
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(casillas[i][j] + "| ");
            }
            System.out.println();
        }
    }

    //aux
    private boolean hayTresEnRaya(EstadoCasilla color) {

//        for (int i = 0; i < DIMENSION; i++) {
//            if (casillas[i][0] == color && casillas[i][1] == color && casillas[i][2] == color) {
//                return true;
//            }
//        }
//
//        for (int j = 0; j < DIMENSION; j++) {
//            if (casillas[0][j] == color && casillas[1][j] == color && casillas[2][j] == color) {
//                return true;
//            }
//        }
//
//        if (casillas[0][0] == color && casillas[1][1] == color && casillas[2][2] == color) {
//            return true;
//        }
//
//        if (casillas[0][2] == color && casillas[1][1] == color && casillas[2][0] == color) {
//            return true;
//        }

//        EstadoCasilla [] comprobacion=new  EstadoCasilla[DIMENSION];

        //fila
        for (int i = 0; i <DIMENSION ; i++) {
            for (int j = 0; j <DIMENSION ; j++) {
            if(casillas[i][j]!=color){
                return false;
            }
            }
        }

        //columna
        for (int i = 0; i <DIMENSION ; i++) {
            for (int j = 0; j <DIMENSION ; j++) {
                if(casillas[j][i]!=color){
                    return false;
                }
            }
        }

        //diagonal primera
        for (int i = 0; i <DIMENSION ; i++) {
            for (int j = 0; j <DIMENSION ; j++) {
                if(casillas[i][i]!=color){
                    return false;
                }
            }
        }

        //diagonal invertida
        for (int i = 0; i <DIMENSION ; i++) {
            for (int j = DIMENSION; j ==0 ; j--) {
                if(casillas[i][j]!=color){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isOcupada(Coordenada coordenada) {

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        return casillas[fila - 1][columna - 1] != EstadoCasilla.VACIO;
    }

    public void ponerFicha(Coordenada coordenada, EstadoCasilla color){

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        casillas[fila - 1][columna - 1] = color;

    }

    public void vaciar(){

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j]=EstadoCasilla.VACIO;
            }
        }
    }

    public boolean estaLleno(){

        boolean estaLleno=true;

        for (int i = 0; i <DIMENSION ; i++) {
            for (int j = 0; j <DIMENSION ; j++) {
                if (casillas[i][j]==EstadoCasilla.VACIO){
                    estaLleno=false;
                }
            }
        }

        return estaLleno;
    }
}
