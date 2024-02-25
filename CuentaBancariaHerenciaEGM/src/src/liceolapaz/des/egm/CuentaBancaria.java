package src.liceolapaz.des.egm;

//Creamos clase padre abstracta publica CuentaBancaria
public abstract class CuentaBancaria {

    //Creamos atributo privado double saldo
    private double saldo;

    //Creamos el constructor para saldo(auto generado)
    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    //Creamos metodo publico void ingresarDinero con parametro double cantidad, dentro definimos condiciones
    public void ingresarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe de ser positiva.");
        } else {
            saldo += cantidad;
        }
    }

    //Creamos metodo retirarDinero publico void con parametro double cantidad, dentro definimos condiciones
    public void retirarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positiva.");
        } else {
            saldo -= cantidad;
        }
    }

    //Creamos metodo publico double consultarSaldo, que devuelve saldo
    public double consultarSaldo() {
        return saldo;
    }

}
