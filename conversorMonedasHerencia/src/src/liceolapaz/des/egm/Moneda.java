package src.liceolapaz.des.egm;

//Definimos clase Moneda, al ser la clase padre es asbtracta
public abstract class Moneda {

    //creamos el atributo cantidad protected double
    //protected porque en la docuentación indica #
    //+ public
    //- private
    //# protected
    //~ package
    protected double cantidad;

    //creamos el constructor de cantidad para incializar la variable cantidad y poder instanciarla en las subclases
    public Moneda(double cantidad) {
        this.cantidad = cantidad;
    }

    //creamos el metodo cantidadEnEuros protected double, los metodos no usan constructores, sino que se sobreescriben en las subclases
    protected abstract double cantidadEnEuros();
}
