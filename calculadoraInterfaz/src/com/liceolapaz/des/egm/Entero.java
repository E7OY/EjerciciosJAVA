package com.liceolapaz.des.egm;

public class Entero extends Numero {  //Se declara una nueva clase Entero que hereda de la clase Numero
    //Como numero es clase abstracta con metodos abstractos, debe proporcionar informacion para todos estos metodos abstractos,
    //Es decir, deberá tener sus propias definiciones de los métodos suma, resta, producto, division y mostrar.

    private int valor;

    public Entero(int valor) {
        this.valor = valor;
    }  //Define un constructor(metodo para inciciar un objeto cuando se crea) para la clase entero

    public int getValor() {
        return valor;
    }  //se auto genera -> click derecho -> Generate Getter y Setter.

    public void setValor(int valor) {
        this.valor = valor;
    }


    @Override  //esto hace que no se sobreescriba el método de la clase base (numero) o padre. En este caso se sobreescribe suma(Numero operando)
    protected Numero suma(Numero operando) {
        Entero resultado = null;    //el valor inicial de los objetos es null
        if (operando instanceof Entero) {   //se verifica si operando es una instancia de entero, si es asi hace la suma
            Entero op = (Entero) operando;
            int nuevovalor = getValor() + op.getValor();  //suma el valor del objeto actual this y el valor del objeto op. getValor() metodo que deveukeve el valor del objeto entero

            resultado = new Entero(nuevovalor); //crea un nuevo objeto entero con el valor nuevo valor y lo almacena en la variable resultado
        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;
    }


    @Override
    protected Numero resta(Numero operando) {
        Entero resultado = null; //el valor inicial de los objetos es null
        if (operando instanceof Entero) {
            Entero op = (Entero) operando;
            int nuevovalor = getValor() - op.getValor();

            resultado = new Entero(nuevovalor);
        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;    }

    @Override
    protected Numero producto(Numero operando) {
        Entero resultado = null; //el valor inicial de los objetos es null
        if (operando instanceof Entero) {
            Entero op = (Entero) operando;
            int nuevovalor = getValor() * op.getValor();

            resultado = new Entero(nuevovalor);
        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;
    }

    @Override
    protected Numero division(Numero operando) {
        Entero resultado = null; //el valor inicial de los objetos es null
        if (operando instanceof Entero) {
            Entero op = (Entero) operando;
            if(op.getValor() != 0){
                int nuevovalor = getValor() / op.getValor();
                resultado = new Entero(nuevovalor);
            } else {
                System.out.println("La division no puede ser entre 0.");
            }

        } else {
            System.out.println("El operando tiene que ser un numero entero");
        }
        return resultado;
    }

    @Override
    protected String mostrar() {
        return "" + valor;
    }  //Define un metodo llamado mostrar que sobreescribe un metodo con el mismo en la clase padre.
    //Mostrar no toma ningun argumento y devuelve un String. La expresion "" + valor es una forma de cinvertir un valor en otro (un int en un String en este caso)
}
