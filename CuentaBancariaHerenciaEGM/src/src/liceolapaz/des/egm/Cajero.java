package src.liceolapaz.des.egm;

import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {
        CuentaBancaria cuenta = null;
        do {
            //Escribir menu principal
            escribirMenuPrincipal();
            //Pedir opcion
            pedirOpcion();
            //Leer opcion y almacenarla
            int opcion = leerOpcion();
            switch (opcion) {
                //Si la opcion es 0
                case 0:
                    //salir
                    System.exit(0);
                    break;
                //Si la opcion es 1
                case 1:
                    //Escribir submenu
                    escribirSubmenu();
                    //PedirOpcion2
                    pedirOpcion();
                    //Leer la opcion 2 y almacenarla
                    int opcion2 = leerOpcion();
                    if (opcion2 == 1) {
                        //Pedir saldo inicial
                        pedirSaldoInicial();
                        //Leer saldo y almacenarlo
                        double saldoInicial = leerDouble();
                        cuenta = new CuentaNormal(saldoInicial);
                    }
                    //Si la opcion 2 es 2
                    else if (opcion2 == 2) {
                        //Pedir saldo inicial
                        pedirSaldoInicial();
                        //Leer saldo y almacenarlo
                        double saldoInicial = leerDouble();
                        cuenta = new CuentaPremium(saldoInicial);
                    }
                    //Si la opcion es 0
                    else if (opcion2 == 0) {
                        //volver al menu principal
                    }
                    //si es otra opcion
                    else {
                        //Mostrar mensahe de error
                        System.out.println("Opcion no valida.");
                    }
                    break;
                //Si la opcion es 2
                case 2:
                    if (cuenta == null) {
                        System.out.println("No hay cuenta activa");
                    } else {
                        //Pedir cantidad
                        pedirCantidad();
                        //Leer cantidad y almacenarla
                        double cantidad = leerDouble();
                        cuenta.ingresarDinero(cantidad);
                        //Escribir saldo
                        System.out.println("El saldo de la cuenta es: " + String.format("%.2f", cuenta.consultarSaldo()) + " €");
                    }
                    break;
                //Si la opcion es 3
                case 3:
                    if (cuenta == null) {
                        System.out.println("No hay cuenta activa");
                    } else {
                        //Pedir cantidad
                        pedirCantidad();
                        //Leer cantidad y almacenarla
                        double cantidad = leerDouble();
                        cuenta.retirarDinero(cantidad);
                        //Escribir saldo
                        System.out.println("El saldo de la cuenta es: " + String.format("%.2f", cuenta.consultarSaldo()) + " €");
                    }
                    break;
                //Si la opcion es 4
                case 4:
                    if (cuenta == null) {
                        System.out.println("No hay cuenta activa.");
                    } else {
                        //Escribir saldo
                        System.out.println("El saldo de la cuenta es: " + String.format("%.2f", cuenta.consultarSaldo()) + " €");
                    }
                    break;
                //si es otra opcion
                default:
                    //Mostrar error
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (true);
    }

    private static void pedirCantidad() {
        System.out.print("Escriba la cantidad: ");
    }

    private static double leerDouble() {
        Scanner escaner = new Scanner(System.in);
        return escaner.nextDouble();
    }

    private static void pedirSaldoInicial() {
        System.out.print("Escriba el saldo inicial: ");
    }

    private static void escribirSubmenu() {
        System.out.println("\nTipo de cuenta\n" + " 1. Cuenta normal\n" + " 2. Cuenta Premium\n" + " 0. Cancelar");
    }

    private static int leerOpcion() {
        Scanner escaner = new Scanner(System.in);
        return escaner.nextInt();
    }

    private static void pedirOpcion() {
        System.out.print("Escoja una opción: ");
    }

    private static void escribirMenuPrincipal() {
        System.out.println("\nBANCO\n" + " 1. Crear cuenta\n" + " 2. Ingresar dinero\n" + " 3. Retirar dinero\n"
                + " 4. Consultar saldo\n" + " 0. Salir");
    }

}
