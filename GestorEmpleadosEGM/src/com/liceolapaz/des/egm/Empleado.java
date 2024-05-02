package com.liceolapaz.des.egm;

import java.util.Date;

public class Empleado {

    private String DNI;
    private String Nombre;
    private String Primer_Apellido;
    private String Segundo_Apellido;
    private Date Fecha_Nacimiento;
    private double Salario;
    private int Departamento;
    private String DNI_Jefe;

    public Empleado(String DNI, String nombre, String primer_Apellido, String segundo_Apellido, Date fecha_Nacimiento, double salario, int departamento, String DNI_Jefe) {
        super();
        this.DNI = DNI;
        this.Nombre = nombre;
        this.Primer_Apellido = primer_Apellido;
        this.Segundo_Apellido = segundo_Apellido;
        this.Fecha_Nacimiento = fecha_Nacimiento;
        this.Salario = salario;
        this.Departamento = departamento;
        this.DNI_Jefe = DNI_Jefe;
    }


    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String primer_Apellido) {
        this.Primer_Apellido = primer_Apellido;
    }

    public String getSegundo_Apellido() {
        return Segundo_Apellido;
    }

    public void setSegundo_Apellido(String segundo_Apellido) {
        this.Segundo_Apellido = segundo_Apellido;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date fecha_Nacimiento) {
        this.Fecha_Nacimiento = fecha_Nacimiento;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        this.Salario = salario;
    }

    public int getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(int departamento) {
        this.Departamento = departamento;
    }

    public String getDNI_Jefe() {
        return DNI_Jefe;
    }

    public void setDNI_Jefe(String DNI_Jefe) {
        this.DNI_Jefe = DNI_Jefe;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "DNI='" + DNI + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Primer_Apellido='" + Primer_Apellido + '\'' +
                ", Segundo_Apellido='" + Segundo_Apellido + '\'' +
                ", Fecha_Nacimiento=" + Fecha_Nacimiento +
                ", Salario=" + Salario +
                ", Departamento=" + Departamento +
                ", DNI_Jefe='" + DNI_Jefe +
                '}';
    }
}
