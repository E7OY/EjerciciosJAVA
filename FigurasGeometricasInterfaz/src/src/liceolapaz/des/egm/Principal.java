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
                    pedirBaseRectangulo();
                    double baseRectangulo = leerBaseRectangulo();
                    pedirAlturaRectangulo();
                    double alturaRectangulo = leerAlturaRectangulo();
                    figura = new Rectangulo(baseRectangulo, alturaRectangulo);
                    break;
                case 3:
                    pedirLadoCuadrado();
                    double ladoCuadrado = leerLadoCuadrado();
                    figura = new Cuadrado(ladoCuadrado);
                    break;
                case 4:
                    pedirLadoPentagono();
                    double ladoPentagono = leerLadoPentagono();
                    pedirApotemaPentagono();
                    double apotemaPentagono = leerApotemaPentagono();
                    figura = new Pentagono(ladoPentagono, apotemaPentagono);
                    break;
            }
            double area = figura.calcularArea();
            double perimetro = figura.calcularPerimetro();
            escribirResultado(area, perimetro);
        } while (true);

    }

    private static double leerApotemaPentagono() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirApotemaPentagono() {
        System.out.print("Escribe el valor de la apotema del pentagono: ");
    }

    private static double leerLadoPentagono() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirLadoPentagono() {
        System.out.print("Escribe el valor de los lados del pentagono: ");
    }

    private static double leerLadoCuadrado() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirLadoCuadrado() {
        System.out.print("Escribe el valor del lado del cuadrado: ");
    }

    private static double leerAlturaRectangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirAlturaRectangulo() {
        System.out.print("Escribe el valor de la altura del rectangulo: ");
    }

    private static double leerBaseRectangulo() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirBaseRectangulo() {
        System.out.print("Escribe el valor de la base del rectangulo: ");
    }

    private static void escribirResultado(double area, double perimetro) {
        System.out.println("El area es: " + area + " y el perimetro es: " + perimetro);
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
