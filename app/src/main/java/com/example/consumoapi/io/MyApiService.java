package com.example.consumoapi.io;

import com.example.consumoapi.model.Firmas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiService {
    @GET("firmas?")
    Call<ArrayList<Firmas>> getFirmas(@Query("correoUsuario") String correoUsuario);

}
