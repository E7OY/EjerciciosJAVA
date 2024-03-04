package com.liceolapaz.des.egm;

public interface Numero { //interfaz numero con visibilidad publica (si la interfaz no es public no será accesbile desde fuera del package), las interfaces son agrupaciones de funciones o metodos
    Numero sumar(Numero operando);  //el metodo suma devolvera un objeto tipo Numero, (Numero operando); toma un argumento de tipo numero llamado operando

    Numero restar(Numero operando);

    //esto hace que no se sobreescriba el método de la clase base (numero) o padre. En este caso se sobreescribe suma(Numero operando)

    Numero suma(Numero operando);

    Numero resta(Numero operando);

    Numero producto(Numero operando);
    Numero division(Numero operando);
    String mostrar();
}

//Numero es la interfaz, que está formada pro un conjunto de declaraciones de funciones (métodos) que son sumar, restar, producto, división y mostrar.
//Una clase es una agrupacion de datos (variables o campos) y de funciones (métodos) que operan sobre estos datos.
//Las clases son como tipos de variables, todas las variables deben pertenecer a una clase.

//En un fichero no puede haber mas que una clase public

