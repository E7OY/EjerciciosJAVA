package egm.liceolapaz.egm.des;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    do {    //Escribir menu
        escribirMenu();
        //Escoger opcion
        escogerOpcion();
        //Leer opcion y almacenarla
        int opcion = leerOpcion();
        if (opcion == 0) {
            System.exit(0);
        } else if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
            //Pedir primer operando
            pedirPrimerOperando();
            //Leer primer operando y almacenarlo
            int primerOperando = leerPrimerOperando();
            //Pedir segundo operando
            pedirSegundoOperando();
            //Leer segundo operando y almacenarlo
            int segundoOperando = leerSegundoOperando();
            int resultado = 0;
            switch(opcion) {
                case 1:
                    resultado = primerOperando + segundoOperando;
                    break;
                case 2:
                    resultado = primerOperando - segundoOperando;
                    break;
                case 3:
                    resultado = primerOperando * segundoOperando;
                    break;
                case 4:
                    resultado = primerOperando / segundoOperando;
                    break;
            } System.out.println("El resultado de la operacion es: " + resultado);
        } else {
            System.out.println("La opcion introducida no es valida.");
        }

    } while(true);
    }

    private static int leerSegundoOperando() {
        Scanner teclado = new Scanner(System.in);
        return  teclado.nextInt();
    }

    private static void pedirSegundoOperando() {
        System.out.print("Escriba el valor del segundo operando: ");
    }


    private static int leerPrimerOperando() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirPrimerOperando() {
        System.out.print("Escriba el valor del primer operando: ");
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escogerOpcion() {
        System.out.print("Escoge una opcion: ");
    }

    private static void escribirMenu() {
        System.out.println("CALCULADORA\n1. Suma\n2. Resta\n3. Producto\n4. División\n0. Salir");
    }
}
