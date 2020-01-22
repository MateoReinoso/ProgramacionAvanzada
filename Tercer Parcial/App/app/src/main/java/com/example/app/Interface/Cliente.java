package com.example.app.Interface;

import com.example.app.Model.GetS;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Cliente {

    @GET("ci")
    Call<List<GetS>> getClient();
}
