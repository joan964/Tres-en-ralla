package org.example;

import java.util.Scanner;

public enum EstadoCasilla {

    O, X,
    VACIO{
        @Override
        public String toString(){
            return " ";
        }
    }

}
