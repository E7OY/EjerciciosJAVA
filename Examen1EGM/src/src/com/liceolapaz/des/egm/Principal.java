package src.com.liceolapaz.des.egm;

import java.util.Random;
import java.util.Scanner;

public class Principal {
        public static void main(String[] args) {
            String[] razas = {"Humano", "Elfo", "Enano", "Orco", "Troll", "Gnomo"};
            String raza = "";
            String[] clases = {"Guerrero", "Cazador", "Clérigo", "Mago", "Druida", "Paladín", "Bardo"};
            String clase = "";
            int fuerza = 0;
            int destreza = 0;
            int inteligencia = 0;
            int sabiduria = 0;
            int carisma = 0;
            int puntosExtra = 5;
            do {
                escribirMenu();
                int opcion = leerOpcion();
                switch(opcion) {
                    case 0:
                        System.out.println("¡Hasta la próxima!");
                        System.exit(0);
                        break;
                    case 1:
                        int numeroRaza = generarNumero(0, razas.length);
                        raza = razas[numeroRaza];
                        System.out.println("La raza generada es: " + raza);
                        break;
                    case 2:
                        int numeroClase = generarNumero(0, clases.length);
                        clase = clases[numeroClase];
                        System.out.println("La clase generada es: " + clase);
                        break;
                    case 3:
                        fuerza = generarNumero(1, 20);
                        destreza = generarNumero(1, 20);
                        inteligencia = generarNumero(1, 20);
                        sabiduria = generarNumero(1, 20);
                        carisma = generarNumero(1, 20);
                        puntosExtra = 5;
                        System.out.println("Las habilidades generadas fueron:\n"
                                + "Fuerza: " + fuerza + "\n"
                                + "Destreza: " + destreza + "\n"
                                + "Inteligencia: " + inteligencia + "\n"
                                + "Sabiduria: " + sabiduria + "\n"
                                + "Carisma: " + carisma);
                        break;
                    case 4:
                        if (puntosExtra <= 0) {
                            System.out.println("No tienes puntos extra para poder asignar");
                        } else {
                            System.out.print("¿A qué habilidad quieres asignar los puntos? " +
                                    "(fuerza, destreza, inteligencia, sabiduría, carisma): ");
                            String habilidad = leerHabilidad();
                            habilidad = habilidad.toLowerCase();
                            System.out.print("¿Cuántos puntos quieres asignar a " + habilidad + "?");
                            int puntos = leerOpcion();
                            if (puntos > puntosExtra) {
                                System.out.println("No tienes tantos puntos extra disponibles");
                            } else if (puntos <= 0) {
                                System.out.println("Los puntos a asignar tienen que ser un valor positivo");
                            } else {
                                switch (habilidad) {
                                    case "fuerza":
                                        if (fuerza + puntos > 20) {
                                            System.out.println("No puedes asignar tantos puntos extra a esta habilidad");
                                        } else {
                                            fuerza = fuerza + puntos; // fuerza += puntos;
                                            puntosExtra = puntosExtra - puntos;
                                        }
                                        break;
                                    case "destreza":
                                        if (destreza + puntos > 20) {
                                            System.out.println("No puedes asignar tantos puntos extra a esta habilidad");
                                        } else {
                                            destreza = destreza + puntos;
                                            puntosExtra = puntosExtra - puntos;
                                        }
                                        break;
                                    case "inteligencia":
                                        if (inteligencia + puntos > 20) {
                                            System.out.println("No puedes asignar tantos puntos extra a esta habilidad");
                                        } else {
                                            inteligencia = inteligencia + puntos;
                                            puntosExtra = puntosExtra - puntos;
                                        }
                                        break;
                                    case "sabiduría":
                                    case "sabiduria":
                                        if (sabiduria + puntos > 20) {
                                            System.out.println("No puedes asignar tantos puntos extra a esta habilidad");
                                        } else {
                                            sabiduria = sabiduria + puntos;
                                            puntosExtra = puntosExtra - puntos;
                                        }
                                        break;
                                    case "carisma":
                                        if (carisma + puntos > 20) {
                                            System.out.println("No puedes asignar tantos puntos extra a esta habilidad");
                                        } else {
                                            carisma = carisma + puntos;
                                            puntosExtra = puntosExtra - puntos;
                                        }
                                        break;
                                    default:
                                        System.out.println("No existe esa habilidad");
                                }
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Raza: " + raza + "\n"
                                + "Clase: " + clase + "\n"
                                + "Fuerza: " + fuerza + "\n"
                                + "Destreza: " + destreza + "\n"
                                + "Inteligencia: " + inteligencia + "\n"
                                + "Sabiduria: " + sabiduria + "\n"
                                + "Carisma: " + carisma);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while(true);
        }

        private static String leerHabilidad() {
            Scanner teclado = new Scanner(System.in);
            return teclado.nextLine();
        }

        private static int generarNumero(int min, int max) {
            Random random = new Random();
            return random.nextInt(max - min) + min;
        }

        private static int leerOpcion() {
            Scanner teclado = new Scanner(System.in);
            return teclado.nextInt();
        }

        private static void escribirMenu() {
            System.out.print("""
                CREACIÓN PERSONAJE DE ROL
                1. Raza
                2. Clase
                3. Habilidades
                4. Puntos extras
                5. Mostrar personaje
                0. Salir
                Escoja una opción: """);
        }
    }
