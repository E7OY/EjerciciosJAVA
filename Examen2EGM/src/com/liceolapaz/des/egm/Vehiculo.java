package com.liceolapaz.des.jprf;

public class Vehiculo {
    private String tipo;
    private String matricula;
    private String dni;
    private String fecha;
    private String hora;

    public Vehiculo(String tipo, String matricula, String dni, String fecha, String hora) {
        this.tipo = tipo;
        this.matricula = matricula;
        this.dni = dni;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo + " "
                + matricula + " "
                + dni + " "
                + fecha + " "
                + hora;
    }
}
