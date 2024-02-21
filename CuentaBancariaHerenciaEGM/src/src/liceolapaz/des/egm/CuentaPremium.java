package src.liceolapaz.des.egm;

public class CuentaPremium extends CuentaBancaria{
    public CuentaPremium(double saldo) {
        super(saldo);
    }

    @Override
    public void retirarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positiva");
        } else {
            super.retirarDinero(cantidad);
        }
    }
}
