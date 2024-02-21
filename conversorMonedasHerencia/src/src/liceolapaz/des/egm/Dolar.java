package src.liceolapaz.des.egm;

public class Dolar extends Moneda {
    private final static double CONVERSION_A_DOLAR = 0.883509299;


    //usamos el super para acceder al constructor que está creado en la clase padre
    public Dolar(double cantidad) {
        super(cantidad);
    }

    @Override
    protected double cantidadEnEuros() {
        double resultado = cantidad * CONVERSION_A_DOLAR;

        return resultado;
    }
}
