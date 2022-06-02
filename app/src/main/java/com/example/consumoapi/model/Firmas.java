package com.example.consumoapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Firmas {//para tener los valores claves de Json como atributos de la clase
    @SerializedName("id") public String id;
    @SerializedName("fechaIngreso") public Date fechaIngreso;
    @SerializedName("link") public String link;
    @SerializedName("correoUsuario") public String correoUsuario;


    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public String getLink() {
        return link;
    }


    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
}
