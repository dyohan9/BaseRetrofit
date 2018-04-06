package com.example.daniel.retrofittest.Utils.Retrofit.Interfaces;

import com.example.daniel.retrofittest.Utils.Retrofit.Login.Login;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Daniel on 05/04/2018.
 */

public interface iRetrofitLogin {

    @Headers("Content-Type: application/json")
    @POST("login")
    Call<Login> getToken(
            @Body String body
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://situacaows.casal.srv.br/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
