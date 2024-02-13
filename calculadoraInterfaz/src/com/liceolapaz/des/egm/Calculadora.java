package com.liceolapaz.des.egm;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        while (true) {
        escribirMenu();
        int opcion = leerOpcion();
        if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
            while (true) {
                escribirSubMenu();
                int opcionSubmenu = leerOpcion();
                switch (opcionSubmenu) {
                    case 0:
                        break;
                    case 1:
                        pedirOperando();
                        int operando = leerOperando();
                        pedirSegundoOperando();
                        int segundoOperando = leerOperando();

                    default:
                        System.out.println("La opcion introducida no es valida.");
                        continue;  //este continue hace que el programa vuelva al inicio del bcule while del submenu (el continue detiene la iteracion del bucle  y vuelve al principio del bucle
                }
                break;  //detiene la ejecuccion del bucle
            }
        } else if (opcion == 0) {
            System.exit(0);
        } else {
            System.out.println("La opcion introducida no es valida.");
        }
    } }

    private static void pedirSegundoOperando() {
        System.out.print("Escribe el valor del segundo operando: ");
    }

    private static int leerOperando() {
       Scanner teclado = new Scanner(System.in);
       return teclado.nextInt();
    }

    private static void pedirOperando() {
        System.out.print("Escribe el valor del primer operando: ");
    }

    private static void escribirSubMenu() {
        System.out.print("Tipo de numeros\n1. Numeros enteros\n2.Numeros racionales\n3. Numeros complejos\n0. Cancelar\nEscoja una opcion: ");
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escribirMenu() {
        System.out.print("CALCULADORA\n1.Suma\n2.Resta\n3.Producto\n4.Division\n0.Salir\nEscoja una opcion: ");
    }
}
