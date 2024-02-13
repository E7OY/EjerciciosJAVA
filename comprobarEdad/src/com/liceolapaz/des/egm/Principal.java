package com.liceolapaz.des.egm;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        do {
            // Pedir año de nacimiento
            pedirAnho();
            // Leer el año y almacenarlo
            int anhoNacimiento = leerAnhoNacimiento();
            // Comprobar el año y guardar mensaje de texto
            String mensaje = comprobarAnhoNacimiento(anhoNacimiento);
            // Escribir mensaje
        }while(true); }


        private static String comprobarAnhoNacimiento ( int anhoNacimiento){
            String mensaje;
            int edad = 2023 - anhoNacimiento;
            if (anhoNacimiento > 2023) {
                mensaje = "No puedes haber nacido en este año";
            } else if (2023 - anhoNacimiento > 150) {
                mensaje = "No puedes tener tantos años";
            } else if (2023 - anhoNacimiento <= 18) {
                mensaje = "Eres menor no puedes pasar";
            } else {
                mensaje = "Puedes pasar";
            }
            System.out.println(mensaje);
            return mensaje;
        }

    private static int leerAnhoNacimiento() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirAnho() {
        System.out.print("Escriba su año de nacimiento: ");
    }
}
