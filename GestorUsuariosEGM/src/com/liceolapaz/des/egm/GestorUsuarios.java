package com.liceolapaz.des.egm;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class GestorUsuarios {

    private static HashMap<Integer, Usuario>  usuarios = new HashMap<>();

    public static void main(String[] args) {


        while (true) {

            escribirMenu();
            pedirOpcion();
            int opcion = leerEntero();
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
                    //Añadir usurio
                    Usuario usuario = crearUsuario();
                    int id = usuario.getId();
                    if (usuarios.containsKey(id)) {
                        System.out.println("Ya existe un usuario conn ese id");
                    } else {
                        usuarios.put(id, usuario);
                    }
                    break;

                case 3:
                    //Modificar usuario
                    usuario = crearUsuario();
                    id = usuario.getId();
                    if (usuarios.containsKey(id)) {
                        usuarios.replace(id, usuario);
                    } else {
                        System.out.println("No existe un usuario con ese id!");
                    }
                    break;

                case 4:
                    //Eliminar usuario
                    pedirDato("id");
                    String idTexto = leerString();
                    id = Integer.parseInt(idTexto);

                    if (usuarios.containsKey(id)) {
                        usuarios.remove(id);
                    } else {
                        System.out.println("El usuario con el id: " + id + " no existe.");
                    }
                    break;

                case 5:
                    //Exportar usuarios
                    pedirRutaExportar();
                    String ruta1 = leerString();
                    exportarFichero(ruta1);
                    break;

                default:
                    System.out.print("Opción no valida!");
            }
        }
    }

    private static void exportarFichero(String ruta1) {
        File fichero = new File(ruta1);
        if (fichero.isFile()) {
            try {
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                String linea = "[";
                pw.println(linea);

                Usuario[] usuariosArray = new Usuario[usuarios.values().size()];
                usuariosArray = usuarios.values().toArray(usuariosArray);
                for (int i = 0; i < usuariosArray.length; i++) {
                    linea = "  {";
                    pw.println(linea);
                    linea = "    \"id\": " + usuario.getId() + ",";
                    pw.println(linea);
                    linea = "    \"email\": \"" + usuario.getEmail() + "\",";
                    pw.println(linea);
                    linea = "    \"first_name\": \"" + usuario.getFirst_name() + "\",";
                    pw.println(linea);
                    linea = "    \"last_name\": \"" + usuario.getLast_name() + "\",";
                    pw.println(linea);
                    linea = "    \"avatar\": \"" + usuario.getAvatar() + "\"";
                    pw.println(linea);
                    pw.println(linea);
                    if (i == usuariosArray.length - 1) {
                        linea = "  }";
                    } else {
                        linea = "  },";
                    }
                    pw.println(linea);
                }

                linea = "]";
                pw.println(linea);

                pw.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("El fichero no se pudo escribir correctamente");
            }
        }
    }

    private static void pedirRutaExportar() {
        System.out.print("Introduce la ruta del fichero a exportar: ");
    }


    private static Usuario crearUsuario() {
        Usuario usuario = null;

        pedirDato("id");
        String idTexto = leerString();
        int id = Integer.parseInt(idTexto);

        pedirDato("email");
        String email = leerString();

        pedirDato("nombre");
        String nombre = leerString();

        pedirDato("apellidos");
        String apellidos = leerString();

        pedirDato("URL");
        String urlTexto = leerString();

        URL avatar;
        try {
            avatar = new URL(urlTexto);
        } catch (MalformedURLException e) {
            System.out.println("URL incorrecta.");
            return null;
        }

        usuario = new Usuario(id, email, nombre, apellidos, avatar);
        return usuario;
    }

    private static void pedirDato(String dato) {
        System.out.println("Introduce el " + dato + ": ");
    }

    private static void leerFichero(String ruta) {
        File archivo = new File(ruta);

        if (archivo.exists() && archivo.isFile()) {
            try {
                Scanner escaner = new Scanner(archivo);
                if (escaner.hasNextLine()) {
                    escaner.nextLine();
                }
                while (escaner.hasNextLine()) {
                    String linea = escaner.nextLine();
                    if (linea.equals("[")) {
                        break;
                    }
                    if (linea.equals("  {")) {
                        linea = escaner.nextLine();
                        String[] campos = linea.split(": ");
                        int id = 0;
                        try {
                            id = Integer.parseInt(campos[1].substring(0, campos[1].length() - 1));
                        } catch (NumberFormatException e) {
                            System.err.println("El id tiene que ser un número entero");
                            return;
                        }

                        linea = escaner.nextLine();
                        campos = linea.split(": ");

                        String email = campos[1].substring(1, campos[1].length() - 2);
                        linea = escaner.nextLine();
                        campos = linea.split(": ");

                        String first_name = campos[1].substring(1, campos[1].length() - 2);
                        linea = escaner.nextLine();
                        campos = linea.split(": ");

                        String last_name = campos[1].substring(1, campos[1].length() - 2);
                        linea = escaner.nextLine();
                        campos = linea.split(": ");

                        String avatarTexto = campos[1].substring(1, campos[1].length() - 1);
                        URL avatar;
                        try {
                            avatar = new URL(avatarTexto);
                        } catch (MalformedURLException e) {
                            System.err.println("El avatar tiene que ser una URL.");
                            return;
                        }


                        Usuario usuario = new Usuario(id, email, first_name, last_name, avatar);
                        usuarios.put(id, usuario);
                        linea += escaner.nextLine();
                    }}
                } catch(FileNotFoundException e){
                    System.out.println("El archivo no se ha leido correctamente.");
                }
            } else{
                System.err.println("El archivo no existe!");
            }
        }


    private static String leerString() {
            Scanner teclado = new Scanner(System.in);
            return teclado.nextLine();
    }

    private static void pedirOpcion() {
        System.out.println("Escoje una opcion: ");
    }

    private static void pedirRuta() {
        System.out.print("Introduce la ruta del fichero a importar: ");
    }

    private static int leerEntero() {
        try {
            Scanner teclado = new Scanner(System.in);
            return teclado.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    private static void escribirMenu() {
        System.out.print("""
                GESTOR USUARIOS
                1. IMPORTAR USUARIOS
                2. AÑADIR USUARIO
                3. MODIFICAR USUARIO
                4. ELIMINAR USUARIO
                5. EXPORTAR USUARIOS
                0. SALIR
                """);
    }
}
