package com.liceolapaz.des.egm;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        do {  //Escribir Menu
            escribirMenu();
            //Pedir Opcion
            pedirOpcion();
            //Leer opcion y almacenarla
            int opcion = leerOpcion();
            if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
                switch (opcion) {
                    case (1):
                        //Pedir lado (base)
                        pedirBase();
                        //Leer base y almacenarla
                        double baseTriangulo = leerBaseTriangulo();
                        //Pedir segundo lado
                        pedirLado();
                        //Leer segundo lado y almacenarlo
                        double ladoTriangulo = leerLadoTriangulo();
                        //Pedir tercer lado
                        pedirTercerLado();
                        //Leer tercer lado y almacenarlo
                        double tercerLadoTriangulo = leerTercerLadoTriangulo();
                        //Pedir altura
                        pedirAltura();
                        //Leer altura y almacenarla
                        double alturaTriangulo = leerAlturaTriangulo();
                        //Calcular area
                        double areaTriangulo;
                        areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                        //Calcular perimetro
                        double perimetroTringulo;
                        perimetroTringulo = (baseTriangulo + ladoTriangulo + tercerLadoTriangulo);
                        System.out.println("El area es " + areaTriangulo + " y el perimetro es " + perimetroTringulo);
                        break;
                    case (2):
                        //Pedir base
                        pedirBaseRectangulo();
                        //Leer base y almacenarla
                        double baseRectangulo = leerBaseRectangulo();
                        //Pedir altura
                        pedirAlturaRectangulo();
                        //Leer altura y almacenarla
                        double alturaRectangulo = leerAlturaRectangulo();
                        //Realizar calculo y pasarlo por pantalla
                        double areaRectangulo = baseRectangulo * alturaRectangulo;
                        double perimetroRectangulo = baseRectangulo + baseRectangulo + alturaRectangulo + alturaRectangulo;
                        System.out.println("El area del rectangulo es " + areaRectangulo + " y el perimetro es " + perimetroRectangulo);
                        break;
                    case (3):
                        //Pedir lado
                        pedirLadoCuadrado();
                        //Leer lado y almacenarlo
                        double ladoCuadrado = leerLadoCuadrado();
                        //Realizar calculo y pasarlo por pantalla
                        double areaCuadrado = ladoCuadrado * ladoCuadrado;
                        double perimetroCuadrado = ladoCuadrado + ladoCuadrado + ladoCuadrado + ladoCuadrado;
                        System.out.println("El area del cuadrado es " + areaCuadrado + " y el perimetro es " + perimetroCuadrado);
                        break;
                    case (4):
                        //Pedir apotema
                        pedirApotemaPentagono();
                        //Leer apotema y almacenar valor
                        double apotemaPentagono = leerApotemaPentagono();
                        //pedir lado
                        pedirLadoPentagono();
                        //Leer lado y almacenarlo
                        double ladoPentagono = leerLadoPentagono();
                        //Realizar calculo y mostrarlo
                        double perimetroPentagono = 5 * ladoPentagono;
                        double areaPentagono = (perimetroPentagono * apotemaPentagono) / 2;
                        System.out.println("El area del pentagono es " + areaPentagono + " y el perimetro es " + perimetroPentagono);
                        break;
                }

            } else if (opcion == 0) {
                System.exit(0);
            } else {
                System.out.println("La opción introducida no es válida.");
            }
        } while (true);

    }

    private static double leerLadoPentagono() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirLadoPentagono() {
        System.out.print("EScriba el valor del lado del pentagono: ");
    }

    private static double leerApotemaPentagono() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirApotemaPentagono() {
        System.out.print("Escriba el valor del apotema del pentagono: ");
    }

    private static double leerLadoCuadrado() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirLadoCuadrado() {
        System.out.print("Escriba el valor del lado del cuadrado: ");
    }

    private static double leerAlturaRectangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirAlturaRectangulo() {
        System.out.print("Escriba el valor de la altura del rectangulo: ");
    }

    private static double leerBaseRectangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirBaseRectangulo() {
        System.out.print("Escriba el valor de la base del rectángulo: ");
    }


    private static double leerTercerLadoTriangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirTercerLado() {
        System.out.print("Escribe el valor del tercer lado del triángulo: ");
    }

    private static double leerLadoTriangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirLado() {
        System.out.print("Escriba el valor del segundo lado del triángulo: ");
    }

    private static double leerAlturaTriangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirAltura() {
        System.out.print("Escriba el valor de la altura del triángulo: ");
    }

    private static double leerBaseTriangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirBase() {
        System.out.print("Escriba el valor del primer lado (base) del triángulo: ");
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirOpcion() {
        System.out.print("Escoja una opcion: ");
    }

    private static void escribirMenu() {
        System.out.println("FIGURAS GEOMETRICAS\n1. Triángulo\n2. Rectángulo\n3. Cuadrado\n4.Pentágono\n0. Salir");
    }
}
