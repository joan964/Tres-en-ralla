package org.example;

public class Tablero {

    public static final int DIMENSION = 2;
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
        System.out.print(" ");
        for (int i = 0; i < DIMENSION; i++) {
            System.out.print(i+1+" |");
        }
        System.out.println("");
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

    //  for (int i = 0; i < DIMENSION; i++) {
      //     if (casillas[i][0] == color && casillas[i][1] == color && casillas[i][2] == color) {
        //      return true;
         // }
       //}

       //for (int j = 0; j < DIMENSION; j++) {
         //   if (casillas[0][j] == color && casillas[1][j] == color && casillas[2][j] == color) {
           //     return true;
           //}
        //}

     // if (casillas[0][0] == color && casillas[1][1] == color && casillas[2][2] == color) {
       //    return true;
       //}

       //if (casillas[0][2] == color && casillas[1][1] == color && casillas[2][0] == color) {
         //  return true;
       //}

      //EstadoCasilla [] comprobacion=new  EstadoCasilla[DIMENSION];


//        return true;

        for (int i = 0; i < DIMENSION; i++) {
            if (verificarLinea(i, 0, 0, 1, color) || verificarLinea(0, i, 1, 0, color)) {
                return true;
            }
        }


        if (verificarLinea(0, 0, 1, 1, color) || verificarLinea(0, DIMENSION - 1, 1, -1, color)) {
            return true;
        }

        return false;
    }

    private boolean verificarLinea(int uno, int dos, int aux, int aux2, EstadoCasilla color) {
        int contador = 0;
        for (int i = 0; i < DIMENSION; i++) {
            if (casillas[uno][dos] == color) {
                contador++;
                if (contador == DIMENSION) {
                    return true;
                }
            } else {
                contador = 0;
            }
            uno += aux;
            dos += aux2;
        }
        return false;
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
