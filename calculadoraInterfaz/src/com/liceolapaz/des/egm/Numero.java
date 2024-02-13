package com.liceolapaz.des.egm;

public abstract class Numero {  //clase llamada numero con visibilidad publica (si la interfaz no es public no será accesbile desde fuera del package) y abtracta, lo que hace que no se pueden crear objetos de ella y permite que otras clases deriven de ella.
    //Las clases abstractas se crean para crear una estructura entre las clases no para instanciar objetos, estas permiten heradar codigo, estructurarlo, etc.
    protected abstract Numero suma(Numero operando);  //metodo dentro de la clase de la interfaz numero, los metodos dentro de las interfaces siempre son public y abstract.
    //protected; la clase puede ser accedida desde cualquier clase del paquete  o culaquier subclase de la clase
    //Numero; es el tipo de retorno del metodo, el metodo suma devolvera un objeto tipo Numero.
    //Numero operando; toma un argumento de tipo numero llamado operando
    protected abstract Numero resta(Numero operando);
    protected abstract Numero producto(Numero operando);
    protected abstract Numero division(Numero operando);
    protected abstract String mostrar();
}

//Numero es la interfaz, que está formada pro un conjunto de declaraciones de funciones (métodos) que son suma, resta, producto, división y mostrar.

//Una clase es una agrupacion de datos (variables o campos) y de funciones (métodos) que operan sobre estos datos.
//Las clases son como tipos de variables, todas las variables deben pertenecer a una clase.
//Los modificadores de acceso pueden ser public, protected, private, package(por defecto)


//En un fichero no puede haber mas que una clase public

