package src.liceolapaz.des.egm;

public class CuentaPremium extends CuentaBancaria{


    //Constructor super que pasa el valor de saldo a la clase padre
    public CuentaPremium(double saldo) {
        super(saldo);
    }

    //Sobre escribimos metodo retirarDinero, con las condiciones para la cuentaPremium indicadas en el enunciado
    @Override
    public void retirarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positiva");
        } else {
            super.retirarDinero(cantidad);
        }
    }
}
