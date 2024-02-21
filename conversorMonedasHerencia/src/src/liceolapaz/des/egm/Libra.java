package src.liceolapaz.des.egm;

public class Libra extends Moneda {
    private final static double CONVERSION_A_LIBRA= 1.1029861;
    public Libra(double cantidad) {
        super(cantidad);
    }
    // 1 British pound = 1.1029861 Euros
    // Generamos el constructor


    //
    @Override
    protected double cantidadEnEuros() {
        double resultado = cantidad * CONVERSION_A_LIBRA;

        return resultado;
    }
}
