package com.example.app.Interface;

import com.example.app.Model.GetZona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Zona {

    @GET("zona")
    Call<List<GetZona>> getZona();
}
