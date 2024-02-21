package org.example;

import java.util.Scanner;

public class TresEnRaya {

    Tablero tablero =new Tablero();

    Jugador [] Jugadores =new Jugador[2];

    public TresEnRaya() {

        Jugadores[0]=new Jugador(EstadoCasilla.X);
        Jugadores[1]=new Jugador(EstadoCasilla.O);
    }
    public void jugar(){

        Scanner scanner = new Scanner(System.in);
        boolean jugarDeNuevo=false;
        int jugadorActivoIndice=0;

        Jugador jugadorActivo;
        boolean volverAjugar=false;
        do {
            tablero.mostrar();
            do {
                jugadorActivo=Jugadores[jugadorActivoIndice];
                jugadorActivo.ponerFicha(tablero);
                tablero.mostrar();
                if(tablero.hayTresEnRaya()){
                    jugadorActivo.cantarVictoria();
                }

                if (tablero.estaLleno()){
                    System.out.println("Empate");
                    System.out.println("¿Quieres volver a jugar? [S/N]: ");
                }

                if(jugadorActivoIndice==0){
                    jugadorActivoIndice=1;
                }else {
                    jugadorActivoIndice=0;
                }

            }while (!tablero.hayTresEnRaya() && !tablero.estaLleno());

            System.out.println("¿Quieres volver a jugar? [S/N]:");
            String respuesta=scanner.next();
            if (respuesta.equals("S")){
                volverAjugar=true;
                tablero.vaciar();
            }else if (respuesta.equals("N")){
                volverAjugar=false;
            }else {
                System.out.println("¡Error! Debes introducir S o N");
            }

        }while (volverAjugar);

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(); }
}
