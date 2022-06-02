package com.example.consumoapi.io.response;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class FirmasResponse {
    @SerializedName("id") public String id;
    @SerializedName("fechaIngreso") public Date fechaIngreso;
    @SerializedName("link") public String link;
    @SerializedName("correoUsuario") public String correoUsuario;

    public FirmasResponse(String id, Date fechaIngreso, String link, String correoUsuario) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.link = link;
        this.correoUsuario = correoUsuario;
    }
}
