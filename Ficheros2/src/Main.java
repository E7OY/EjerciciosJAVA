import java.io.*;
import java.util.Scanner;

/*
Crear un proyecto llamado Ficheros*** (donde *** son vuestras iniciales). El proyecto deberá
tener una sola clase llamada Principal, que esté dentro de un package con el nombre
com.liceolapaz.des.*** (donde *** son vuestras iniciales). El programa deberá escribir el
siguiente menú principal por pantalla:
FICHEROS
1. Leer fichero de texto
2. Copiar fichero
3. Listar archivos de directorio
0. Salir
Escoja una opción:
Al escoger la opción 1 del menú principal, se deberá pedir por pantalla la ruta del fichero de
texto con un mensaje similar a “Escriba la ruta del fichero: ”. Una vez obtenida la ruta, el
programa mostrará por pantalla el contenido del fichero. Si la ruta no es un fichero se deberá
mostrar un mensaje de error similar a “La ruta *** no es un fichero” (donde *** es la ruta
introducida por el usuario).
Al escoger la opción 2 del menú principal, saldrá el siguiente submenú por pantalla:
Tipo de fichero a copiar
1. Fichero de texto
2. Fichero binario
0. Cancelar
Escoja una opción:
Si se escogen las opciones 1 o 2 del submenú, se deberá pedir por pantalla primero la ruta del
fichero de origen y luego la ruta del fichero de destino con mensajes similares a “Escriba la ruta
del fichero de origen: ” y “Escriba la ruta del fichero de destino: ”. Una vez obtenidas las rutas,
el programa copiará el contenido del fichero de origen en el fichero de destino, sobrescribiendo
cualquier contenido previo que tuviese. Si la ruta de origen no es un fichero se deberá mostrar
un mensaje de error similar a “La ruta *** no es un fichero” (donde *** es la ruta introducida
por el usuario).
Si se escoge la opción 0 del submenú, el programa mostrará de nuevo el menú principal.
Si se escoge una opción distinta a las que muestra el submenú, se deberá mostrar por pantalla un
mensaje de error advirtiendo que la opción introducida no es válida y se deberá dejar escoger
otra opción sin tener que salir al menú principal.
Si se escoge la opción 3 del menú principal, se deberá pedir por pantalla la ruta del directorio
con un mensaje similar a “Escriba la ruta del directorio: ”. Una vez obtenida la ruta, el programa
mostrará por pantalla un listado de ficheros del directorio, poniendo en cada línea del listado el
nombre de un fichero y su tamaño en KB. Si la ruta no es un directorio se deberá mostrar un
mensaje de error similar a “La ruta *** no es un directorio” (donde *** es la ruta introducida
por el usuario).
Al escoger la opción 0 del menú principal, el programa terminará y no dejará realizar más
operaciones.
Si se escoge una opción distinta a las que muestra el menú principal, se deberá mostrar por
pantalla un mensaje de error advirtiendo que la opción introducida no es válida.
AÑADIDO:
Al escoger la opcion4, se debera pedir por pantalla la ruta del fichero de texto con un mensaje similar a “Escriba la ruta del fichero: ”. Una vez obtenida la ruta, el
programa permitira escribir en el fichero de texto. Si la ruta no es un fichero se deberá
 */
public class Main {
    public static void main(String[] args) {

        escribirMenu();
        int opcion = leerEntero();

        switch (opcion) {
            case 1:
                pedirRuta();
                String ruta = leerString();
                leerFicheroTexto(ruta);
                break;
            case 2:
                pedirRutaOrigen();
                String rutaOrigen = leerString();
                pedirRutaDestino();
                String rutaDestino = leerString();
                copiarFichero(rutaOrigen, rutaDestino);
                break;
            case 3:
                pedirRuta();
                String rutaDirectorio = leerString();
                listarArchivosDirectorio(rutaDirectorio);
                break;
            case 4:
                pedirRuta();
                String rutaFichero = leerString();
                escribirFicheroTexto(rutaFichero);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void escribirFicheroTexto(String rutaFichero) {
        File archivo = new File(rutaFichero);
        if (!archivo.isFile()) {
            System.out.println("El archivo no es un fichero de texto.");
        } else {
            try {
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                System.out.println("Escribe el texto que quieras añadir al fichero: ");
                String texto = leerString();
                pw.println(texto);

                pw.close();
                bw.close();
                fw.close();

            } catch (IOException e) {
                System.out.println("Error de entrada/salida.");
            }
        }
    }

    private static void listarArchivosDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            for (File archivo : archivos) {
                System.out.println(archivo.getName() + " - " + archivo.length() / 1024 + " KB");
            }
        } else {
            System.out.println("La ruta " + rutaDirectorio + " no es un directorio.");
        }
    }

    private static void copiarFichero(String rutaOrigen, String rutaDestino) {
        File archivoOrigen = new File(rutaOrigen);
        File archivoDestino = new File(rutaDestino);

        if (!archivoOrigen.isFile()) {
            System.out.println("La ruta " + rutaOrigen + " no es un fichero.");
        } else {
            try (FileInputStream fis = new FileInputStream(archivoOrigen);
                 BufferedInputStream bis = new BufferedInputStream(fis);

                 FileOutputStream fos = new FileOutputStream(archivoDestino, false);
                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {

                byte[] buffer = new byte[1024];
                int bytesLeidos;

                while ((bytesLeidos = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesLeidos);
                }

            } catch (FileNotFoundException e) {
                System.out.println("No se ha encontrado el archivo.");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida.");
            }
        }
    }

    private static void pedirRutaDestino() {
        System.out.print("Introduce la ruta de destino: ");
    }

    private static void pedirRutaOrigen() {
        System.out.print("Introduce la ruta del archivo a copiar: ");
    }

    private static void leerFicheroTexto(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.isFile()) {
            System.out.println("El archivo no es un fichero de texto.");
        } else {
            try {
                FileInputStream fis = new FileInputStream(archivo);
                BufferedInputStream bis = new BufferedInputStream(fis);
                byte[] buffer = new byte[1024];
                int bytesLeidos = bis.read(buffer);

                while (bytesLeidos != -1) {
                    System.out.println(new String(buffer, 0, bytesLeidos));
                }

                fis.close();
                bis.close();

            } catch (FileNotFoundException e) {
                System.out.println("No se ha encontrado el archivo.");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida.");
            }
        }
    }

    private static String leerString() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static void pedirRuta() {
        System.out.println("Escriba la ruta del fichero: ");
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escribirMenu() {
        System.out.print("""
                FICHEROS
                1. LEER FICHERO DE TEXTO   
                2. COPIAR FICHEROS
                3. LISTAR ARCHIVOS DE DIRECTORIO
                4. ESCRIBE FICHERO DE TEXTO
                0. SALIR
                ESCOJA UN OPCION: 
                """);
    }
}