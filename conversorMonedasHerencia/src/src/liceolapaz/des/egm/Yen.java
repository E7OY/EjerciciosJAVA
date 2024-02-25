package src.liceolapaz.des.egm;

public class Yen extends Moneda {
    private final static double CONVERSION_A_YEN= 0.00779327499;

    // Generamos el constructor
    public Yen(double cantidad) {
        super(cantidad);
    }


    //Sobreescribimos metodo
    @Override
    protected double cantidadEnEuros() {
        double resultado = cantidad * CONVERSION_A_YEN;

        return resultado;
    }
}
