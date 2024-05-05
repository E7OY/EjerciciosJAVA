package com.liceolapaz.des.egm;

public class Departamento {

    private int num_depto;
    private String nombre;
    private String nombre_corto;
    private int planta;
    private String cif_director;
    private String correo_e;

    public Departamento(int num_depto, String nombre, String nombre_corto, int planta, String cif_director, String correo_e) {
        super();
        this.num_depto = num_depto;
        this.nombre = nombre;
        this.nombre_corto = nombre_corto;
        this.planta = planta;
        this.cif_director = cif_director;
        this.correo_e = correo_e;
    }

    public int getNum_depto() {
        return num_depto;
    }

    public void setNum_depto(int num_depto) {
        this.num_depto = num_depto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public String getCif_director() {
        return cif_director;
    }

    public void setCif_director(String cif_director) {
        this.cif_director = cif_director;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public void setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
    }

    @Override
    public String toString() {
        return "Departamento [num_depto=" + num_depto + ", nombre=" + nombre + ", nombre_corto=" + nombre_corto
                + ", planta=" + planta + ", cif_director=" + cif_director + ", correo_e=" + correo_e + "]";
    }
}
