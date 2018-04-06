package com.example.daniel.retrofittest;

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

public interface iRetrofitGitHub {
//    @GET("/users/{usuario}")
//    Call<Usuario> getUsuario(@Path("usuario") String usuario);

    @Headers("Content-Type: application/json")
    @POST("login")
    Call<User> getToken(
            @Body String body
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://situacaows.casal.srv.br/")//https://api.github.com/
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
