package com.liceolapaz.des.egm;

public class Entero implements Numero {
    //Se declara una nueva clase Entero que implementa de la clase Numero


    //Declaramos la variable especifica de la clase entero valor:, que es un dato o atributo de numero
    private int valor;

    public Entero(int valor) {
        this.valor = valor;
    }  //Define un constructor(metodo para inciciar un objeto cuando se crea) para la clase entero(autogenerado)

    public int getValor() {
        return valor;
    }  //se auto genera -> click derecho -> Generate Getter y Setter.

    public void setValor(int valor) {
        this.valor = valor;
    }


    @Override
    public Numero sumar(Numero operando) { //esto hace que no se sobreescriba el método de la clase padre (numero) o super. En este caso se sobreescribe suma(Numero operando)
        Entero resultado = null;    //el valor inicial de los objetos es null
        //Comprobamos con instanceof que la variable operando sea un numero entero
        if (operando instanceof Entero) {
            //Creamos una variable local, para que tome operando como un entero en vez de como Numero
            Entero op = (Entero) operando;

            resultado = new Entero(getValor() + op.getValor());
            //suma el valor del objeto actual this y el valor del objeto op. getValor() metodo que deveukeve el valor del objeto entero
        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;
    }

    @Override
    public Numero restar(Numero operando) {
        Entero resultado = null; //el valor inicial de los objetos es null
        if (operando instanceof Entero) {
            Entero op = (Entero) operando;
            resultado = new Entero(getValor() - op.getValor());
        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;
    }



    @Override
    public Numero producto(Numero operando) {
        Entero resultado = null; //el valor inicial de los objetos es null
        if (operando instanceof Entero) {
            Entero op = (Entero) operando;
            resultado = new Entero(getValor() * op.getValor());
        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;
    }

    @Override
    public Numero division(Numero operando) {
        Entero resultado = null; //el valor inicial de los objetos es null
        if (operando instanceof Entero) {
            Entero op = (Entero) operando;
            if(op.getValor() != 0){
                resultado = new Entero(getValor() / op.getValor());
            } else {
                System.out.println("La division no puede ser entre 0.");
            }

        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;
    }

    @Override
    public String mostrar() {
        return "" + valor;
    }  //Define un metodo llamado mostrar que sobreescribe un metodo con el mismo en la clase padre.
    //Mostrar no toma ningun argumento y devuelve un String. La expresion "" + valor es una forma de convertir un valor en otro (un int en un String en este caso)
}
