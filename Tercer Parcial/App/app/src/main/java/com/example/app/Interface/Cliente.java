package com.example.app.Interface;

import com.example.app.Model.GetCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Cliente {

    @GET("cliente")
    Call<List<GetCliente>> getCliente();
}
