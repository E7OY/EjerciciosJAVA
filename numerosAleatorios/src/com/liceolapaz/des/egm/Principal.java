package com.liceolapaz.des.egm;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Pedir numero a buscar al usuario
        pedirNumeroABuscar();
        // Leer el numero a buscar y guardarlo
        int numeroBuscar = leerEntero();
        // Pedir numero maximo de intentos
        pedirMaximoIntentos();
        // Leer numero maximo de intentos y guardarlo
        int maximoIntentos = leerEntero();
        // Generar numeros aleatorios
        int numeroIntentos = 0;
        while (numeroIntentos < maximoIntentos) {
            // generar numero aleatorio y guardarlo
            int numeroAleatorio = generarNumeroAleatorio(1, 10);
            // Escribir el numero aleatorio generado
            System.out.println("El numero aleatorio generado es: " + numeroAleatorio);
            // Sumar un intento
            numeroIntentos++;
            if (numeroAleatorio == numeroBuscar) {
                System.out.println("El numero encontrado es "+ numeroAleatorio + " en " + numeroIntentos + " intentos.");
                break;
            } else if (numeroIntentos == maximoIntentos) {
                System.out.println("Numero no encontrado.\n" + "El numero de intentos ha sido de: " + numeroIntentos);
            }

        }
    }


    private static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static void pedirMaximoIntentos() {
        System.out.print("Escriba el maximo de intentos: ");
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirNumeroABuscar() {
        System.out.print("Escriba un numero del 1 al 10: ");
    }
}
