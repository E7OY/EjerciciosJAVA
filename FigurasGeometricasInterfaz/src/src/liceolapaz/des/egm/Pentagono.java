package src.liceolapaz.des.egm;

public class Pentagono implements FiguraGeometrica{
    private double lado;
    private double apotema;

    public Pentagono(double lado, double apotema) {
        super();
        this.lado = lado;
        this.apotema = apotema;
    }

    @Override
    public double calcularArea() {
        return ((lado * 5) * apotema) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return (lado * 5);
    }
}
