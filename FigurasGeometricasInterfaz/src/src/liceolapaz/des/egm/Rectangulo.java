package src.liceolapaz.des.egm;

public class Rectangulo implements FiguraGeometrica{
    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        super();
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura);
    }

    @Override
    public double calcularPerimetro() {
        return base + base + altura + altura;
    }
}
