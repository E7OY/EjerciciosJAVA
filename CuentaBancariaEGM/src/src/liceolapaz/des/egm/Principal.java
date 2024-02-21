package src.liceolapaz.des.egm;

import java.util.Scanner;

public class Principal {
    private static final int SIN_CUENTA = 0;
    private static final int CUENTA_NORMAL = 1;
    private static final int CUENTA_PREMIUM = 2;

    private static int tipoCuenta = SIN_CUENTA;
    private static double saldoCuenta = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("BANCO\n1. Crear cuenta\n2. Ingresar dinero\n3. Retirar dinero\n4. Consultar saldo\n0. Salir\nEscoja una opción:");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCuenta(scanner);
                    break;
                case 2:
                    ingresarDinero(scanner);
                    break;
                case 3:
                    retirarDinero(scanner);
                    break;
                case 4:
                    consultarSaldo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opcion valida");
            }
        } while (opcion != 0);
    }

    private static void crearCuenta(Scanner scanner) {
        System.out.print("Tipo de cuenta\n1. Cuenta normal\n2. Cuenta Premium\n0. Cancelar\nEscoja una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case CUENTA_NORMAL:
            case CUENTA_PREMIUM:
                System.out.print("Escriba el saldo inicial: ");
                saldoCuenta = scanner.nextDouble();
                tipoCuenta = opcion;
                break;
            case SIN_CUENTA:
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void ingresarDinero(Scanner scanner) {
        if (tipoCuenta == SIN_CUENTA) {
            System.out.println("No hay una cuenta activa");
            return;
        }
        System.out.println("Escriba la cantidad:");
        double cantidad = scanner.nextDouble();
        if (cantidad < 0) {
            System.out.println("La cantidad debe ser positiva");
            return;
        }
        saldoCuenta = saldoCuenta + cantidad;
        System.out.println("El saldo de la cuenta es " + saldoCuenta);
    }

    private static void retirarDinero(Scanner scanner) {
        if (tipoCuenta == SIN_CUENTA) {
            System.out.println("No hay una cuenta activa");
            return;
        }
        System.out.println("Escriba la cantidad:");
        double cantidad = scanner.nextDouble();
        if (cantidad < 0 || (tipoCuenta == CUENTA_NORMAL && saldoCuenta - cantidad < 0)) {
            System.out.println("La cantidad debe ser positiva y el saldo no puede ser negativo");
            return;
        }
        saldoCuenta = saldoCuenta - cantidad;
        System.out.println("El saldo de la cuenta es " + saldoCuenta);
    }

    private static void consultarSaldo() {
        if (tipoCuenta == SIN_CUENTA) {
            System.out.println("No hay una cuenta activa");
            return;
        }
        System.out.println("El saldo de la cuenta es " + saldoCuenta);
    }
}

