package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int numeroCochesGasolina = 50;
        int numeroCochesDiesel = 30;
        int numeroCochesElectricos = 5;
        int numeroCochesHibridos = 15;
        int numeroMotosGasolina = 35;
        int numeroMotosElectricas = 15;
        int numeroFurgonetas = 20;
        Vehiculo[] vehiculosAlquilados =
                new Vehiculo[numeroCochesGasolina
                + numeroCochesDiesel
                + numeroCochesElectricos
                + numeroCochesHibridos
                + numeroMotosGasolina
                + numeroMotosElectricas
                + numeroFurgonetas];

        do {
           escribirMenu();
           pedirOpcion();
           int opcion = leerOpcion();
           switch (opcion){
               case 0:
                   System.exit(0);
                   break;
               case 1:
                   escribirSubMenu();
                   pedirOpcion();
                   int tipo = leerOpcion();
                   switch (tipo) {
                       case 1:
                           if (numeroCochesGasolina > 0) {
                               Vehiculo vehiculo = crearVehiculo("Coche gasolina");
                               for (int i = 0; i < vehiculosAlquilados.length; i++) {
                                   if (vehiculosAlquilados[i] == null) {
                                       vehiculosAlquilados[i] = vehiculo;
                                       numeroCochesGasolina--;
                                       System.out.println("Vehículo alquilado correctamente");
                                       break;
                                   }
                               }
                           } else {
                               System.out.println("No hay coches de gasolina disponibles para alquilar");
                           }
                           break;
                       case 2:
                           if (numeroCochesDiesel > 0) {
                               Vehiculo vehiculo = crearVehiculo("Coche diésel");
                               for (int i = 0; i < vehiculosAlquilados.length; i++) {
                                   if (vehiculosAlquilados[i] == null) {
                                       vehiculosAlquilados[i] = vehiculo;
                                       numeroCochesDiesel--;
                                       System.out.println("Vehículo alquilado correctamente");
                                       break;
                                   }
                               }
                           } else {
                               System.out.println("No hay coches diésel disponibles para alquilar");
                           }
                           break;
                       case 3:
                           if (numeroCochesElectricos > 0) {
                               Vehiculo vehiculo = crearVehiculo("Coche eléctrico");
                               for (int i = 0; i < vehiculosAlquilados.length; i++) {
                                   if (vehiculosAlquilados[i] == null) {
                                       vehiculosAlquilados[i] = vehiculo;
                                       numeroCochesElectricos--;
                                       System.out.println("Vehículo alquilado correctamente");
                                       break;
                                   }
                               }
                           } else {
                               System.out.println("No hay coches eléctricos disponibles para alquilar");
                           }
                           break;
                       case 4:
                           if (numeroCochesHibridos > 0) {
                               Vehiculo vehiculo = crearVehiculo("Coche híbrido");
                               for (int i = 0; i < vehiculosAlquilados.length; i++) {
                                   if (vehiculosAlquilados[i] == null) {
                                       vehiculosAlquilados[i] = vehiculo;
                                       numeroCochesHibridos--;
                                       System.out.println("Vehículo alquilado correctamente");
                                       break;
                                   }
                               }
                           } else {
                               System.out.println("No hay coches híbridos disponibles para alquilar");
                           }
                           break;
                       case 5:
                           if (numeroMotosGasolina > 0) {
                               Vehiculo vehiculo = crearVehiculo("Moto gasolina");
                               for (int i = 0; i < vehiculosAlquilados.length; i++) {
                                   if (vehiculosAlquilados[i] == null) {
                                       vehiculosAlquilados[i] = vehiculo;
                                       numeroMotosGasolina--;
                                       System.out.println("Vehículo alquilado correctamente");
                                       break;
                                   }
                               }
                           } else {
                               System.out.println("No hay motos de gasolina disponibles para alquilar");
                           }
                           break;
                       case 6:
                           if (numeroMotosElectricas > 0) {
                               Vehiculo vehiculo = crearVehiculo("Moto eléctrica");
                               for (int i = 0; i < vehiculosAlquilados.length; i++) {
                                   if (vehiculosAlquilados[i] == null) {
                                       vehiculosAlquilados[i] = vehiculo;
                                       numeroMotosElectricas--;
                                       System.out.println("Vehículo alquilado correctamente");
                                       break;
                                   }
                               }
                           } else {
                               System.out.println("No hay motos eléctricas disponibles para alquilar");
                           }
                           break;
                       case 7:
                           if (numeroFurgonetas > 0) {
                               Vehiculo vehiculo = crearVehiculo("Furgoneta");
                               for (int i = 0; i < vehiculosAlquilados.length; i++) {
                                   if (vehiculosAlquilados[i] == null) {
                                       vehiculosAlquilados[i] = vehiculo;
                                       numeroFurgonetas--;
                                       System.out.println("Vehículo alquilado correctamente");
                                       break;
                                   }
                               }
                           } else {
                               System.out.println("No hay furgonetas disponibles para alquilar");
                           }
                           break;
                       default:
                           System.out.println("Tipo de vehículo no válido");
                           break;
                   }
                   break;
               case 2:
                   pedirMatricula();
                   String matricula = leerString();
                   boolean encontrado = false;
                   for (int i = 0; i < vehiculosAlquilados.length; i++) {
                       Vehiculo vehiculo = vehiculosAlquilados[i];
                       if (vehiculo != null
                               && vehiculo.getMatricula().equals(matricula)) {
                           vehiculosAlquilados[i] = null;
                           encontrado = true;
                           switch(vehiculo.getTipo()) {
                               case "Coche gasolina":
                                   numeroCochesGasolina++;
                                   break;
                               case "Coche diésel":
                                   numeroCochesDiesel++;
                                   break;
                               case "Coche eléctrico":
                                   numeroCochesElectricos++;
                                   break;
                               case "Coche híbrido":
                                   numeroCochesHibridos++;
                                   break;
                               case "Moto gasolina":
                                   numeroMotosGasolina++;
                                   break;
                               case "Moto eléctrica":
                                   numeroMotosElectricas++;
                                   break;
                               case "Furgoneta":
                                   numeroFurgonetas++;
                                   break;
                           }
                           System.out.println("Vehículo devuelto correctamente");
                           break;
                       }
                   }
                   if (!encontrado) {
                       System.out.println("El vehículo con matrícula " +  matricula + " no estaba alquilado");
                   }
                   break;
               case 3:
                   boolean hayVehiculosAlquilados = false;
                   for (int i = 0; i < vehiculosAlquilados.length; i++) {
                       if (vehiculosAlquilados[i] != null) {
                           hayVehiculosAlquilados = true;
                           System.out.println(vehiculosAlquilados[i]);
                       }
                   }
                   if (!hayVehiculosAlquilados) {
                       System.out.println("\nNo hay vehículos alquilados");
                   }
                   break;
               case 4:
                   System.out.println();
                   System.out.println("Coches gasolina: " + numeroCochesGasolina);
                   System.out.println("Coches diésel: " + numeroCochesDiesel);
                   System.out.println("Coches eléctricos: " + numeroCochesElectricos);
                   System.out.println("Coches híbridos: " + numeroCochesHibridos);
                   System.out.println("Motos gasolina: " + numeroMotosGasolina);
                   System.out.println("Motos eléctricas: " + numeroMotosElectricas);
                   System.out.println("Furgonetas: " + numeroFurgonetas);
                   break;
               default:
                   System.out.println("Opción no válida");
                   break;
           }
        } while(true);
    }

    private static void pedirMatricula() {
        System.out.print("Escriba la matrícula: ");
    }

    private static Vehiculo crearVehiculo(String tipo) {
        System.out.print("Introduzca el DNI: ");
        String dni = leerString();
        System.out.print("Introduzca la matrícula: ");
        String matricula = leerString();
        System.out.print("Introduzca la fecha: ");
        String fecha = leerString();
        System.out.print("Introduzca la hora: ");
        String hora = leerString();
        return new Vehiculo(tipo, matricula, dni, fecha, hora);
    }

    private static String leerString() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static void escribirSubMenu() {
        System.out.println("""
                
                TIPO DE VEHÍCULO
                1. Coche gasolina
                2. Coche diésel
                3. Coche eléctrico
                4. Coche híbrido
                5. Moto gasolina
                6. Moto eléctrica
                7. Furgoneta
                """);
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirOpcion() {
        System.out.print("Escoja una opción: ");
    }

    private static void escribirMenu() {
        System.out.println("""
                
                ALQUILERES
                1. Alquiler vehículo
                2. Devolución vehículo
                3. Listar vehículos alquilados
                4. Mostrar número de vehículos sin alquilar
                0. Salir
                """);
    }
}
