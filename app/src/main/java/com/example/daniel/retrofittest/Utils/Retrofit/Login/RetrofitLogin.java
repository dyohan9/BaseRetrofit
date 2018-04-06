package com.example.daniel.retrofittest.Utils.Retrofit.Login;

import android.content.Context;
import android.util.Log;

import com.example.daniel.retrofittest.Utils.Retrofit.Interfaces.iRetrofitLogin;

import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitLogin {

    public RetrofitLogin(final Context context, String Login, String Password){
        iRetrofitLogin operacionalUser = iRetrofitLogin.retrofit.create(iRetrofitLogin.class);
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("username", Login);
            paramObject.put("password", Password);

            Call<Login> userCall = operacionalUser.getToken(paramObject.toString());
            userCall.enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    int code = response.code();
                    if (code == 200 || code == 201) {
                        Login login = response.body();
                        Log.d("Token: ", ""+login.Token);
//                        context.startActivity(new Intent(context, MainActivity.class));
                    } else {
                        Log.d("Error: ", ""+code);
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
