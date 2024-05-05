package com.liceolapaz.des.egm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GestorDepartamentos {

    private static HashMap <Integer, Departamento> departamentos = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            escribirMenu();
            int opcion = leerEntero();
            switch (opcion) {

                case 1:
                    pedirRuta();
                    String ruta = leerString();
                    leerFichero(ruta);
                    break;

                case 2:
                    Departamento departamento = crearDepartamento();
                    int num_depto = departamento.getNum_depto();
                    if (departamentos.containsKey(num_depto)) {
                        System.err.println("Ya existe un departamento con el numero de departamento: " + num_depto);
                    } else {
                        departamentos.put(num_depto, departamento);
                        System.out.println(departamentos);
                    }
                    break;

            }
            }
    }

    private static Departamento crearDepartamento() {
        Departamento departamento = null;

        pedirDato("Numero de departamento");
        String numero = leerString();
        int num_depto = 0;
        num_depto = Integer.parseInt(numero);

        pedirDato("Nombre");
        String nombre = leerString();

        pedirDato("Nombre corto");
        String nombreCorto = leerString();

        pedirDato("Planta");
        String planta = leerString();
        int numPlanta = 0;
        numPlanta = Integer.parseInt(planta);

        pedirDato("cif director");
        String cifDirector = leerString();

        pedirDato("correo empresa");
        String correoEmpresa = leerString();

         departamento = new Departamento(num_depto, nombre, nombreCorto, numPlanta, cifDirector, correoEmpresa);

        return departamento;

    }

    private static void pedirDato(String dato) {
        System.out.println("Introduce el dato " +dato + " : ");
    }

    private static void pedirNumeroDepartamento() {
        System.out.print("Introduce el numero de departamento a añadir: ");
    }

    private static void leerFichero(String ruta) {
        File fichero = new File(ruta);

        if (!fichero.exists()) {
            System.out.print("El fichero no existe!!");
        } else {
            try {
                Scanner escaner = new Scanner(fichero);
                if (escaner.hasNextLine()) {
                    escaner.nextLine();
                }
                while(escaner.hasNextLine()) {
                    String linea = escaner.nextLine();
                    String[] campos = linea.split(";");  //separamos los campos por ; como esta en el fichero de texto

                    String num_deptoTexto = campos[0];
                    int num_depto;
                    try {
                        num_depto = 0;
                        num_depto = Integer.parseInt(num_deptoTexto);
                    } catch (NumberFormatException e) {
                        System.out.println("El numero de departamento tiene que ser un número enter.");
                        return;
                    }

                    String nombre = campos[1];

                    String nombre_corto = campos[2];

                    String plantaTexto = campos[3];
                    int planta;
                    try {
                        planta = 0;
                        planta = Integer.parseInt(plantaTexto);
                    } catch (NumberFormatException e) {
                        System.out.println("El numero de planta tiene que ser un número entero.");
                        return;
                    }

                    String cif_director = campos[4];

                    String correo_e = campos[5];

                    Departamento departamento = new Departamento(num_depto, nombre, nombre_corto, planta, cif_director, correo_e);

                    departamentos.put(num_depto, departamento);

                    System.out.println(departamento);
                }
            } catch (FileNotFoundException e) {
                System.out.println("El fichero no se ha leido correctamente.");
            }
        }
    }

    private static String leerString() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static void pedirRuta() {
        System.out.print("Introduce la ruta del fichero a importar: ");
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escribirMenu() {
        System.out.print("""
                GESTOR EMPLEADOS
                1. IMPORTAR DEPARTAMENTOS
                2. AÑADIR DEPARTAMENTO
                3. MODIFICAR DEPARTAMENTO
                4. ELIMINAR DEPARTAMENTO
                5. EXPORTAR DEPARTAMENTOS
                0. SALIR
                ESCOJA UNA OPCION:""");
    }
}
