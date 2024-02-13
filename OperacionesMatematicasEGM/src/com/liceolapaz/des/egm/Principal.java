package com.liceolapaz.des.egm;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    do {    //EScribie menu
        mostrarMenu();
        //Pedir la opcion
        pedirOpcion();
        //Leer opcion y almacenarla
        int opcion = leerOpcion();

        switch (opcion) {
            case 1:
                //Pedir base potencia
                pedirBasePotencia();
                //Leer la base y almacenarla
                double basePotencia = leerBasePotencia();
                //Pedir exponente potencia
                pedirExponentePotencia();
                //Leer el exponente y almacenarlo
                double exponentePotencia = leerExponentePotencia();
                //Calcular la potencia y mostrar el resultado
                double resultado = Math.pow(basePotencia, exponentePotencia);
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            case 2:
                //Pedir operando raiz
                pedirOperandoRaiz();
                //Leer operando y almacenarlo
                double operando = leerOperando();
                //Calcular raiz y escribir resultado
                double resultadoRaiz = Math.sqrt(operando);
                System.out.println("El resultado de la operacion es: " + resultadoRaiz);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("!¡La opcion introducida no es válida¡!");
        }
    } while (true);

    }

    private static double leerOperando() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirOperandoRaiz() {
        System.out.print("Introduzca el operando de la raiz cuadrada: ");
    }

    private static double leerExponentePotencia() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirExponentePotencia() {
        System.out.print("Introduzca el valor del exponente de la potencia: ");
    }

    private static double leerBasePotencia() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirBasePotencia() {
        System.out.print("Introduzca el valor de la base de la potencia: ");
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirOpcion() {
        System.out.print("Escoja una opcion: ");
    }

    private static void mostrarMenu() {
        System.out.println("POTENCIAS Y RAICES CUADRADAS\n1. Potencia\n2. Raiz cuadrada\n3. Salir");
    }
}
