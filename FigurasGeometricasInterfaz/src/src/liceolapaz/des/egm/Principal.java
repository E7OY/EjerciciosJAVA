package src.liceolapaz.des.egm;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        do {
            escribirMenu();
            int opcion = leerOpcion();
            FiguraGeometrica figura = null;
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    pedirPrimerLadoTriangulo();
                    double primerLado = leerPrimerLado();
                    pedirSegundoLadoTriangulo();
                    double segundoLado = leerSegundoLado();
                    pedirBaseTriangulo();
                    double baseTriangulo = leerBase();
                    pedirAlturaTriangulo();
                    double alturaTriangulo = leerAltura();
                    figura = new Triangulo(primerLado, segundoLado, baseTriangulo, alturaTriangulo);
                    break;
                case 2:
                case 3:
                case 4:



            }
            double area = figura.calcularArea();
            escribirResultado(area);
        } while (true);

    }

    private static void escribirResultado(double area) {
        System.out.println("El area es: " + area);
    }

    private static double leerSegundoLado() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirSegundoLadoTriangulo() {
        System.out.print("Escribe el valor del segundo lado del triangulo: ");
    }

    private static double leerPrimerLado() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirPrimerLadoTriangulo() {
        System.out.print("Escribe el valor del primer lado del triangulo: ");
    }

    private static double leerAltura() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirAlturaTriangulo() {
        System.out.print("Escribe el valor de la altura del triangulo: ");
    }

    private static double leerBase() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirBaseTriangulo() {
        System.out.print("Escribe el valor de la base del triangulo: ");
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escribirMenu() {
        System.out.print("FIGURAS GEOMÉTRICAS\n" +
                "1. Triángulo\n" +
                "2. Rectángulo\n" +
                "3. Cuadrado\n" +
                "4. Pentágono\n" +
                "0. Salir\n" +
                "Escoja una opción: ");
    }
}
