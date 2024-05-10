package com.liceolapaz.des.egm;

import java.net.URL;

public class Usuario {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private URL avatar;

    public Usuario(int id, String email, String first_name, String last_name, URL avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public URL getAvatar() {
        return avatar;
    }

    public void setAvatar(URL avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
return "Usuario [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
                + ", avatar=" + avatar + "]";
    }
}
