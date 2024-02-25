package src.liceolapaz.des.egm;

public class Libra extends Moneda {
    private final static double CONVERSION_A_LIBRA= 1.1029861;

    // Generamos el constructor
    public Libra(double cantidad) {
        super(cantidad);
    }


    //sobreescribimos el metodo
    @Override
    protected double cantidadEnEuros() {
        double resultado = cantidad * CONVERSION_A_LIBRA;

        return resultado;
    }
}
