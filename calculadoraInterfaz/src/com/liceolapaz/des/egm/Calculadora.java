package com.liceolapaz.des.egm;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        do {
            escribirMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                case 4:
                    escribirSubMenu();
                    int opcionSubMenu = leerOpcion();
                    Numero numero1 = null;
                    Numero numero2 = null;
                    switch (opcionSubMenu) {
                        case 1:
                            pedirOperando();
                            int operando = leerOperando();
                            pedirSegundoOperando();
                            int segundoOperando = leerOperando();
                            numero1 = new Entero(operando);
                            numero2 = new Entero(segundoOperando);
                            break;
                        case 2:
                            pedirNumerador();
                            int primerNumerador = leerNumero();
                            pedirDenominador();
                            int primerDenominador = leerNumero();
                            numero1 = new Racional(primerNumerador, primerDenominador);
                            System.out.println("Introduce ahora los datos de la siguiente fracción: ");
                            pedirNumerador();
                            int segundoNumerador = leerNumero();
                            pedirDenominador();
                            int segundoDenominador = leerNumero();
                            numero2 = new Racional(segundoNumerador, segundoDenominador);
                            break;
                        case 3:
                            pedirNumerador();
                            int primerNumeradorComplejo = leerNumero();
                            pedirDenominador();
                            int primerDenominadorComplejo = leerNumero();
                            numero1 = new Complejo(primerNumeradorComplejo, primerDenominadorComplejo);
                            System.out.println("Introduce ahora los datos de la siguiente fracción: ");
                            pedirNumerador();
                            int segundoNumeradorComplejo = leerNumero();
                            pedirDenominador();
                            int segundoDenominadorComplejo = leerNumero();
                            numero2 = new Complejo(segundoNumeradorComplejo, segundoDenominadorComplejo);
                            break;
                    }
                    Numero resultado = null;

                    switch (opcion) {
                        case 1:
                            resultado = numero1.suma(numero2);
                            break;
                        case 2:
                            resultado = numero1.resta(numero2);
                            break;
                        case 3:
                            resultado = numero1.producto(numero2);
                            break;
                        case 4:
                            resultado = numero1.division(numero2);
                            break;
                    }
                    if (resultado != null) {
                        System.out.println("El resultado es: " + resultado.mostrar());
                    }
            }
        } while (true);
    }

    private static void pedirDenominador() {
        System.out.print("Introduce el valor del primer denominador: ");
    }

    private static int leerNumero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirNumerador() {
        System.out.print("Introduce el valor del primer numerador: ");
    }

    private static void pedirSegundoOperando() {
        System.out.print("Escribe el valor del segundo operando: ");
    }

    private static int leerOperando() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirOperando() {
        System.out.print("Introduzca el valor del primer operando: ");
    }

    private static void escribirSubMenu() {
        System.out.println("Tipo de números\n 1. Números enteros\n 2. Números racionales\n 3. Números complejos\n 0. Cancelar\nEscoja una opción: ");
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escribirMenu() {
        System.out.println("CALCULADORA\n 1. Suma\n 2. Resta\n 3. Producto\n 4. División\n 0. Salir\nEscoja una opción: ");
    }
}
