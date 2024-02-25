package src.liceolapaz.des.egm;


//Creamos subclase dolar que extiende(hereda) atributos y metodos de moneda
public class Dolar extends Moneda {

    //Creamos constante para el valor del dolar
    private final static double CONVERSION_A_DOLAR = 0.883509299;


    /*usamos el constructor super para acceder al constructor que está creado en la clase padre (autogenerado), que representa la cantidad de dinero en dolar, este
    valor se pasa al constructor de la clase padre Moneda a través de la palabra clave super*/
    public Dolar(double cantidad) {
        super(cantidad);
    }

    /*Sobreescribimos el metodo cantidadEnEuros con la converion de euros a dolar, multiplicando la cantidad de dinero en dolares (almacenada en la variable
    cantidad por la tasa de conversion almacenada en la variable, luego devuelve el resultado*/
    @Override
    protected double cantidadEnEuros() {
        double resultado = cantidad * CONVERSION_A_DOLAR;
        return resultado;
    }
}
