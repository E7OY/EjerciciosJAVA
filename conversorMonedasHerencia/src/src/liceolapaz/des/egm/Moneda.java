package src.liceolapaz.des.egm;

public abstract class Moneda {
    //protected porque en la docuentación indica #
    //- privado
    //+ publico

    protected double cantidad;

    public Moneda(double cantidad) {
        this.cantidad = cantidad;
    }

    protected abstract double cantidadEnEuros();
}
