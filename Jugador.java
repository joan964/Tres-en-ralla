package org.example;

import java.util.Scanner;

public class Jugador {

    public EstadoCasilla ficha;

    public Jugador(EstadoCasilla ficha) {
        this.ficha = ficha;
    }

    public void ponerFicha(Tablero tablero) {
        Coordenada coordenada = recogerCoordenada();
        while (tablero.isOcupada(coordenada)) {
            System.out.println("¡Error! Coordenada ocupada en el tablero");
            coordenada = recogerCoordenada();
        }
        tablero.ponerFicha(coordenada, ficha);
    }

    private Coordenada recogerCoordenada() {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;

        do {
            System.out.println("Jugador con " + ficha);
            System.out.print("Introduce fila [1-"+Tablero.DIMENSION+"]: ");
            while (!scanner.hasNextInt()) {
                System.out.println("¡Error! Debe introducir un número entero");
                System.out.print("Introduce fila [1-"+Tablero.DIMENSION+"]: ");
                scanner.next();
            }
            fila = scanner.nextInt();

            System.out.print("Introduce columna [1-"+Tablero.DIMENSION+"]: ");
            while (!scanner.hasNextInt()) {
                System.out.println("¡Error! Debe introducir un número entero");
                System.out.print("Introduce columna [1-"+Tablero.DIMENSION+"]: ");
                scanner.next();
            }
            columna = scanner.nextInt();

            Coordenada coordenada = new Coordenada(fila, columna);
            if (!coordenada.isValida(Tablero.DIMENSION)) {
                System.out.println("¡Error! Introduce una coordenada válida");
            } else {
                return coordenada;
            }
        } while (true);
    }

    public void cantarVictoria() {
        System.out.println("¡El jugador " + ficha + " es el ganador!");
    }
}
