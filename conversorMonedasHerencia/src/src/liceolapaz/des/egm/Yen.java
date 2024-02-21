package src.liceolapaz.des.egm;

public class Yen extends Moneda {
    private final static double CONVERSION_A_YEN= 0.00779327499;
    public Yen(double cantidad) {
        super(cantidad);
    }
    // Generamos el constructor


    //
    @Override
    protected double cantidadEnEuros() {
        double resultado = cantidad * CONVERSION_A_YEN;

        return resultado;
    }
}
