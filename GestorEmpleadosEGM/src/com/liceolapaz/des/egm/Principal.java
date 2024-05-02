package com.liceolapaz.des.egm;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    private static HashMap<String, Empleado> empleados = new HashMap<>();  //Mapa de empleados con el DNI como clave y el objeto Empleado como valor en el mapa

    public static void main(String[] args) {

        while (true) {
            escribirMenu();
            int opcion = leerEntero();

            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    //Leer empleados de un fichero
                    pedirRutaFichero();
                    String ruta = leerString();
                    leerFichero(ruta);
                    break;

                case 2:
                    //Insertar empleado
                    Empleado nuevoEmpleado = crearEmpleados();
                    if (nuevoEmpleado != null) {  //si el empleado no es null
                        String dni = nuevoEmpleado.getDNI();  //guardamos el DNI del empleado en una variable
                        if (empleados.containsKey(dni)) {  //si ya existe un empleado con el mismo DNI
                            System.err.println("Ya existe un empleado con el DNI: " + dni);  //mostramos un mensaje de error
                        }
                        empleados.put(dni, nuevoEmpleado);  //añadimos el empleado al mapa de empleados con el DNI como clave y el objeto Empleado como valor en el mapa de empleados
                        System.out.println(empleados); //mostramos el mapa de empleados
                    }
                    break;

                case 3:
                    //Eliminar empleado
                    pedirDato("dni");
                    String dni = leerString();
                    if (!empleados.containsKey(dni)) {
                        System.err.println("No existe un empleado con el DNI: " + dni);
                        continue;
                    }
                    empleados.remove(dni);  //eliminamos el empleado del mapa de empleados con el DNI como clave
                    //System.out.println(empleados);
                    break;

                case 4:
                    //Modificar empleado
                    Empleado empleadoModificado = crearEmpleados();
                    dni = empleadoModificado.getDNI();
                    if (!empleados.containsKey(dni)) {  //si no existe un empleado con el mismo DNI
                        System.err.println("No existe un empleado con el DNI: " + dni);
                        continue;
                    }
                    empleados.replace(dni, empleadoModificado);  //reemplazamos el empleado con el mismo DNI por el empleado modificado
                    System.out.println(empleados);
                    break;

                case 5:
                    //Exportar empleados
                    pedirRuta();
                    ruta = leerString();
                    exportarEmpleados(ruta);
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    private static void exportarEmpleados(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            //Escribimos la cabecera del fichero, con el numero total de empleados y la fecha actual
            String linea = "";
            LocalDateTime fechaActual = LocalDateTime.now();
            linea += "Fecha: " + fechaActual.getDayOfMonth() + "/"  +
                    fechaActual.getMonthValue() + "/" +
                    fechaActual.getYear();
            pw.println(linea);  //escribimos la variable linea en el fichero

            linea = "";
            linea += "Numero de empleados:  " + empleados.size();  //guardamos el numero de empleados, extraidos con el metodo size del mapa de empleados en la variable linea
            pw.println(linea);  //escribimos la variable linea en el fichero

            linea = "";
            int contador = 1;
            for (Empleado empleado : empleados.values()) {  //recorremos el mapa de empleados con el metodo values y guardamos cada empleado en la variable empleado
                linea = "===============";
                pw.println(linea); //escribimos la variable linea en el fichero
                linea = "Empleado " + contador;  //guardamos el numero de empleado en la variable linea
                pw.println(linea);
                linea = "===============";
                pw.println(linea);
                linea = "DNI: " + empleado.getDNI();
                pw.println(linea);
                linea = "Nombre: " + empleado.getNombre();
                pw.println(linea);
                linea = "Primer Apellido: " + empleado.getPrimer_Apellido();
                pw.println(linea);
                linea = "Segundo Apellido: " + empleado.getSegundo_Apellido();
                pw.println(linea);
                LocalDateTime fecha = empleado.getFecha_Nacimiento().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                linea = "Fecha de Nacimiento: " + fecha.getYear() + "/" +
                        fecha.getMonthValue() + "/" + fecha.getDayOfMonth();
                pw.println(linea);
                linea = "Salario: " + empleado.getSalario();
                pw.println(linea);
                linea = "Número de Departamento: " + empleado.getDepartamento();
                pw.println(linea);
                linea = "DNI Jefe: " + empleado.getDNI_Jefe();
                pw.println(linea);
                contador++;
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir el fichero");
        }
    }

    private static void pedirRuta() {
        System.out.print("Escriba la ruta del fichero: ");
    }

    private static Empleado crearEmpleados() {
        Empleado empleado = null;

        pedirDato("dni");
        String dni = leerString();

        pedirDato("nombre");
        String nombre = leerString();

        pedirDato("primer apellido");
        String primerApellido = leerString();

        pedirDato("segundo apellido");
        String segundoApellido = leerString();
        if (segundoApellido.equals("")) {
            segundoApellido = null;
        }

        pedirDato("fecha de nacimiento (dd/mm/aaaa)");
        String fecha = leerString();
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        } catch (ParseException e) {
            System.err.println("La fecha tiene que estar en formato dd/mm/aaaa");
            return null;
        }

        pedirDato("salario");
        String salarioString = leerString();
        double salario = 0;
        try {
            salario = Double.parseDouble(salarioString);
        } catch (NumberFormatException e) {
            System.err.println("El salario tiene formato incorrecto");
            return null;
        }

        pedirDato("número de departamento");
        String numero = leerString();
        int numeroDepartamento = 0;
        try {
            numeroDepartamento = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            System.err.println("El número de departamento tiene formato incorrecto");
            return null;
        }

        pedirDato("DNI del jefe");
        String dniJefe = leerString();
        if (dniJefe.equals("")) {
            dniJefe = null;
        }
        empleado = new Empleado(dni, nombre, primerApellido, segundoApellido, fechaNacimiento, salario, numeroDepartamento, dniJefe);
        return empleado;
    }

    private static void pedirDato(String dato) {
        System.out.print("Escriba el " + dato + ": ");
    }

    private static void leerFichero(String ruta) {
        File fichero = new File(ruta);  //creamos un objeto File con la ruta del fichero
        if (!fichero.isFile()) {  //verificamos que la ruta sea un fichero
            System.out.println("El fichero " + ruta + " no es un fichero");
        } else {
            try {
                //Leemos el fichero con el file reader o con el escaner que es mas facil
                Scanner escaner = new Scanner(fichero);
                if (escaner.hasNextLine()) {  //verificamos que el archivo tenga contenido (lineas) con metodo hasNextLine de la clase Scanner
                    escaner.nextLine();   //saltamos la primera linea porque que es la cabecera del archivo
                }

                    while (escaner.hasNextLine()) {
                        //Mientras que el fichero tenga mas lineas, las almacenamos en la variable linea
                        String linea = escaner.nextLine();
                        String[] columnas = linea.split(","); //separar los campos de las lineas por comas

                        //Con el metodo substring decimos en que caracter queremos empezar y en cual acabar, al substring le podemos pasar un solo parametro que es el caracter donde queremos empezar y nos devolvera la cadena desde ese caracter hasta el final o dos indices (el inicio y el final)
                        String DNI = columnas[0].substring(2, 11); //guardamos el DNI en una variable extraida de la columna 0 caracter 2 al 11

                        String nombre = columnas[1].substring(2, columnas[1].length() - 1); //desde el caracter 1 hasta la longuitud de la cadena menos 1 caracter (para quitar las comillas)

                        String primerApellido = columnas[2].substring(2, columnas[2].length() - 1);

                        String segundoApellido = null; //inicializamos la variable segundoApellido a null en caso de que no haya segundo apellido
                        if (!columnas[3].equals("NULL")) { //si la columna 3 no es igual a NULL (si  hay segundo apellido):
                            segundoApellido = columnas[3].substring(2, columnas[3].length() - 1);
                        }


                        String fechaTexto = columnas[4].substring(2, columnas[4].length() - 1); //guardamos la fecha como String y luego la parseamos a Date
                        Date fechaNacimiento = null; //inicializamos la variable fechaNacimiento a null en caso de que no haya fecha de nacimiento
                        try {
                            fechaNacimiento = new SimpleDateFormat("yyyy/MM/dd").parse(fechaTexto); //convertimos la fecha de nacimiento a un objeto Date con el formato yyyy/MM/dd
                        } catch (ParseException e) {
                            System.err.println("La fecha tiene que estar en el formato yyyy/MM/dd");
                            continue;
                        }

                        String salarioString = columnas[5].substring(2, columnas[5].length() - 1);
                        double salario = 0; //inicializamos la variable salario a 0 en caso de que no haya salario
                        try {
                            salario = Double.parseDouble(salarioString); //parseamos el String a double
                        } catch (NumberFormatException e) {
                            System.err.println("El salario un formato incorrecto");
                            continue;
                        }


                        String numero = columnas[6].substring(1);
                        int departamento = 0;
                        try {
                            departamento = Integer.parseInt(numero); //convertimos el numero de departamento String a un entero
                        } catch (NumberFormatException e) {
                            System.err.println("El numero de departamento tiene que ser un entero");
                            continue;
                        }

                        String DNI_Jefe = null; //inicializamos la variable DNI_Jefe a null en caso de que no haya DNI del jefe
                        if (!columnas[7].equals("NULL)")) {
                            DNI_Jefe = columnas[7].substring(2, columnas[7].length() - 1);
                        }

                        Empleado empleado = new Empleado(DNI, nombre, primerApellido, segundoApellido, fechaNacimiento, salario, departamento, DNI_Jefe); //creamos un objeto Empleado con los datos extraidos del fichero

                        empleados.put(DNI, empleado); //añadimos el empleado al mapa de empleados con el DNI como clave y el objeto Empleado como valor en el mapa de empleados (si ya existe un empleado con el mismo DNI lo sobreescribe)

                        System.out.println(empleado);

                    }
            } catch (FileNotFoundException e) {
                System.err.println("La ruta: " + ruta + " no existe.");
             }
        }
    }

    private static String leerString() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static void pedirRutaFichero() {
        System.out.print("Introduce la ruta del fichero a importar: ");
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escribirMenu() {
        System.out.print("""
                GESTOR EMPLEADOS:
                1.IMPORTAR EMPLEADOS
                2.AÑADIR EMPLEADO
                3.MODIFICAR EMPLEADO
                4.ELIMINAR EMPLEADO
                5.EXPORTAR EMPLEADOS
                0.SALIR
                ESCOJA UNA OPCION:
                """);
    }
}


