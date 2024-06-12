/*
Crear un proyecto llamado Examen3*** (donde *** son vuestras iniciales). Las clases del proyecto deberán
estar dentro de un package con el nombre com.liceolapaz.des.*** (donde *** son vuestras iniciales).
El objetivo de la aplicación será gestionar pilotos, permitiendo importar y exportar los pilotos a partir de
ficheros como el proporcionado como ejemplo. Y además deberá permitir añadir, modificar y eliminar los
pilotos almacenados en dicha aplicación.
La aplicación deberá escribir el siguiente menú principal por pantalla:
GESTOR PILOTOS
1. Importar pilotos
2. Añadir piloto
3. Modificar piloto
4. Eliminar piloto
5. Exportar pilotos
0. Salir
Escoja una opción:
Si se escoge la primera opción, la aplicación le pedirá al usuario que introduzca la ruta del fichero en donde
están los pilotos que quiere leer. Si el fichero no existe se mostrará un error y, si el fichero existe, la
aplicación leerá ese fichero y almacenará los pilotos leídos, haciendo las distintas comprobaciones para
que no haya datos incorrectos como fechas en formatos incorrectos o textos en campos numéricos.
Si se escoge la segunda opción, la aplicación le pedirá al usuario que introduzca todos los datos del piloto
y hará las respectivas comprobaciones para que el usuario no introduzca datos incorrectos como por
ejemplo introducir una fecha en formato incorrecto o un texto en un campo que tiene que ser numérico.
Una vez introducidos correctamente todos los datos del piloto, se añadirá este nuevo piloto a los pilotos ya
almacenados previamente, comprobando previamente si no existe un piloto almacenado con esa clave. En
el caso de que ya exista un piloto almacenado con esa clave se mostrará un mensaje de error.
Si se escoge la tercera opción, la aplicación le pedirá al usuario que introduzca todos los datos del piloto
y hará las respectivas comprobaciones para que el usuario no introduzca datos incorrectos como por
ejemplo introducir una fecha en formato incorrecto o un texto en un campo que tiene que ser numérico.
Una vez introducidos correctamente todos los datos del piloto, se comprobará que hay un piloto almacenado
con esa clave y se modificará dicho piloto con los datos introducidos por el usuario. En el caso de que no
exista un piloto almacenado con esa clave se mostrará un mensaje de error.
Si se escoge la cuarta opción, la aplicación le pedirá al usuario que introduzca la clave del piloto. En el caso
de que no exista un piloto almacenado con esa clave se mostrará un mensaje de error. En el caso de que sí
exista, se eliminará de los pilotos almacenados.
Si se escoge la quinta opción, la aplicación le pedirá al usuario que introduzca la ruta del fichero en donde
quiere exportar los pilotos y luego la aplicación escribirá en ese fichero los pilotos almacenados en la
aplicación en el formato del fichero proporcionado como ejemplo.
Al escoger la opción 0 del menú principal, el programa se terminará.
Si se escoge una opción distinta a las que muestra el menú principal, se deberá mostrar por pantalla un
mensaje de error advirtiendo que la opción introducida no es válida y deberá mostrar de nuevo el menú
principal.
También se deberá mostrar un mensaje de error si al escoger una opción en lugar de escribir un número se
escribe un texto.
El fichero a importar tiene el siguiente aspecto:
drivers:
- driverId: albon
  permanentNumber: '23'
  code: ALB
  url: http://en.wikipedia.org/wiki/Alexander_Albon
  givenName: Alexander
  familyName: Albon
  dateOfBirth: '1996-03-23'
  nationality: Thai
 */
package com.liceolapaz.des.egm;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorPilotos {

    private  static HashMap<String, Piloto> pilotos = new HashMap<>();

    public static void main(String[] args) {

        do {
            escribirMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    pedirRuta();
                    String ruta = leerString();
                    leerFichero(ruta);
                    break;

                case 2:
                    Piloto piloto = crearPiloto();
                    String driverId = piloto.getDriverId();
                    if (pilotos.containsKey(driverId)) {
                        System.err.println("Ya existe un piloto con la el driverId" + driverId);
                    } else {
                        pilotos.put(driverId, piloto);
                    }
                    break;

                case 3:
                    piloto = crearPiloto();
                    driverId = piloto.getDriverId();
                    if (pilotos.containsKey(driverId)) {
                        pilotos.replace(driverId, piloto);
                    } else {
                        System.err.println("No existe un piloto con el id: " + driverId);
                    }
                    break;

                case 4:
                    pedirDato("driverId");
                    driverId = leerString();
                    if (pilotos.containsKey(driverId)) {
                        pilotos.remove(driverId);
                    } else {
                        System.err.println("No existe un piloto con el dirverId: " + driverId);
                    }
                    break;

                case 5:
                    pedirRutaExportar();
                    String rutaExportar = leerString();
                    exportarPilotos(rutaExportar);
                    break;

                default:
                    System.err.println("Opción no válida");
                    break;
            }
        }while (true);
    }

    private static void exportarPilotos(String rutaExportar) {
        File fichero = new File(rutaExportar);
        FileWriter fw = null;
        try {
            fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String linea = "drivers:";
            pw.println(linea);
            for (Piloto piloto : pilotos.values()) {
                linea = "- driverId: " + piloto.getDriverId();
                pw.println(linea);
               linea = "  permanentNumber: '" + piloto.getPermanentNumber() + "'";
                pw.println(linea);
                linea = "  code: " + piloto.getCode();
                pw.println(linea);
                linea = "  url: " + piloto.getUrl();
                pw.println(linea);
                linea = "  givenName: " + piloto.getGivenName();
                pw.println(linea);
                linea = "  familyName: " + piloto.getFamilyName();
                pw.println(linea);
                linea = "  dateOfBirth: '" + new SimpleDateFormat("yyyy-MM-dd").format(piloto.getDateOfBirth()) + "'";
                pw.println(linea);
               linea = "  nacionality: " + piloto.getNationality();
                pw.println(linea);
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir los pilotos");
        }

    }

    private static void pedirRutaExportar() {
        System.out.print("Introduce la ruta del fichero a exportar: ");
    }

    private static Piloto crearPiloto() {
        Piloto piloto = null;

        pedirDato("driverId");
        String driverId = leerString();

        pedirDato("permanentNumber");
        String permanentNumberTexto = leerString();
        int permanentNumber = 0;
        try {
            permanentNumber = Integer.parseInt(permanentNumberTexto);
        } catch (NumberFormatException e) {
            System.err.println("El numero permanente tiene formato incorrecto");
            return null;
        }

        pedirDato("code");
        String code = leerString();

        pedirDato("url");
        String urlTexto = leerString();
        URL url;
        try {
            url = new URL(urlTexto);
        } catch (MalformedURLException e) {
            System.err.println("El enlace tiene que ser una URL");
            return null;
        }

        pedirDato("givenName");
        String givenName = leerString();

        pedirDato("familyName");
        String familyName = leerString();

        pedirDato("dateOfBirth aaaa/mm/dd");
        String fecha = leerString();
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
        } catch (ParseException e) {
            System.err.println("La fecha tiene que estar en formato aaaa/mm/dd");
            return null;
        }

        pedirDato("nacionality");
        String nacionality = leerString();

        piloto = new Piloto(driverId, permanentNumber, code, url, givenName, familyName, dateOfBirth, nacionality);
        return piloto;
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirDato(String dato) {
        System.out.print("Introduce el " + dato + ": ");
    }

    private static void leerFichero(String ruta) {
        File fichero = new File(ruta);
        if (fichero.exists()) {
            try {
                Scanner escaner = new Scanner(fichero);
                if (escaner.hasNext()) {
                    escaner.nextLine();
                    while (escaner.hasNext()) {
                        String linea = escaner.nextLine();

                        String driverId = linea.substring(linea.indexOf(": ") + 2);
                        linea = escaner.nextLine();

                        String permanentNumberTexto = linea.substring(linea.indexOf(": ") + 3, linea.length() - 1);
                        int permanentNumber = 0;
                        try {
                            permanentNumber = Integer.parseInt(permanentNumberTexto);
                        } catch (NumberFormatException e) {
                            System.err.println("El numero permanente debe ser un numero entero.");
                            continue;
                        }
                        linea = escaner.nextLine();

                        String code = linea.substring(linea.indexOf(": ") + 2);
                        linea = escaner.nextLine();

                        String urlTexto = linea.substring(linea.indexOf(": ") + 2);
                        URL url;
                        try {
                            url = new URL(urlTexto);
                        } catch (MalformedURLException e) {
                            System.err.println("La url tiene que ser una URL");
                            continue;
                        }
                        linea = escaner.nextLine();

                        String givenName = linea.substring(linea.indexOf(": ") + 2);
                        linea = escaner.nextLine();

                        String familyName = linea.substring(linea.indexOf(": ") + 3, linea.length() - 1);
                        linea = escaner.nextLine();

                        String fecha = linea.substring(linea.indexOf(": ") + 3, linea.length() - 1);
                        Date dateOfBirth = null;
                        try {
                            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                        } catch (ParseException e) {
                            System.err.println("La fecha tiene que estar en formato yyyy/MM/dd");
                            continue;
                        }
                        linea = escaner.nextLine();

                        String nationality = linea.substring(linea.indexOf(": ") + 2);

                        Piloto piloto = new Piloto(driverId, permanentNumber, code, url, givenName, familyName, dateOfBirth, nationality);
                        pilotos.put(driverId, piloto);
                    }
                }
                System.out.println(pilotos);
            } catch (FileNotFoundException e) {
                System.err.println("La ruta introducida: " + ruta + " no existe.");
            }
        } else {
            System.err.println("El fichero no existe!");
        }
    }


    private static String leerString() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static void pedirRuta() {
        System.out.print("Introduce la ruta del fichero con los pilotos a importar: ");
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        try {
            opcion = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("La opción tiene que ser un número entero.");
        }
        return opcion;
    }

    private static void escribirMenu() {
        System.out.print("""
                GESTOR PILOTOS
                1. Importar pilotos
                2. Añadir piloto
                3. Modificar piloto
                4. Eliminar piloto
                5. Exportar pilotos
                0. Salir
                Escoja una opción: """);
    }
}
