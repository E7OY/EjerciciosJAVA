package com.liceolapaz.des.egm;

import java.util.Scanner;

public class Principal {


    private static final double YEN_A_EURO = 0.0075;
    private static final double LIBRA_A_EURO = 1.19;
    private static final double DOLAR_A_EURO = 0.86;


    public static void main(String[] args) {
        do {
        //Escribir menu
        escribirMenu();
        //Pedir opcion
        pedirOpcion();
        //Leer opcion y almacenarla
        int opcion = leerOpcion();
        //Mostrar mensaje
        if (opcion == 1 || opcion == 2 || opcion == 3) {
            //Pedir cantidad
            pedirCantidad();
            //Leer cantidad y almacenarla
            double cantidad = leerCantidad();
            //
            String resultado = null;
            switch (opcion) {
                case 1:
                    resultado = cantidad * DOLAR_A_EURO + "€";
                    break;
                case 2:
                    resultado = cantidad * LIBRA_A_EURO + "€";
                    break;
                case 3:
                    resultado = cantidad * YEN_A_EURO + "€";
                    break;
            }
            System.out.println("La cantidad en euros es: " + resultado);

        } else if (opcion == 0) {
            System.exit(0);
            } else {
            System.out.println("La opción introducida no es válida.");
        }
        } while(true);
    }

    private static double leerCantidad() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirCantidad() {
        System.out.print("Escriba una cantidad: ");
    }


    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirOpcion() {
        System.out.print("Escoja una opcion: ");
    }

    private static void escribirMenu() {
        System.out.println("CONVERSOR DE MONEDAS\n1. Dolares\n2. Libras\n3. Yens\n0. Salir");
    }
}
