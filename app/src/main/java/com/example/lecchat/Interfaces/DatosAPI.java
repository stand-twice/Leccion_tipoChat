package com.example.lecchat.Interfaces;

import com.example.lecchat.Esquema.Datos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DatosAPI {

    @GET("lecciones/{id}")
    public Call<Datos> find (@Path("id") int id);
}
