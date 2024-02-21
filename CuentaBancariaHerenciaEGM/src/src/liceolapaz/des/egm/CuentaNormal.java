package src.liceolapaz.des.egm;

public class CuentaNormal extends CuentaBancaria{
    public CuentaNormal(double saldo) {
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
