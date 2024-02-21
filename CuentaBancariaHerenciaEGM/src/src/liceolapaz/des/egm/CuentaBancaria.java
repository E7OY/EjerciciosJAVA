package src.liceolapaz.des.egm;

public abstract class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldo) {
        super();
        this.saldo = saldo;
    }

    public void ingresarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe de ser positiva.");
        } else {
            saldo += cantidad;
        }
    }

    public void retirarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positiva.");
        } else {
            saldo -= cantidad;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

}
