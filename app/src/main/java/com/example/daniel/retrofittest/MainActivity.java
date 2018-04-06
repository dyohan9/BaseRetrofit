package com.example.daniel.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<User> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iRetrofitGitHub githubUser = iRetrofitGitHub.retrofit.create(iRetrofitGitHub.class);
//        final Call<Usuario> call = githubUser.getUsuario("dyohan9");
//
//        call.enqueue(new Callback<Usuario>() {
//            @Override
//            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
//                int code = response.code();
//                if (code == 200) {
//                    Usuario usuario = response.body();
//                    Toast.makeText(getBaseContext(), "Nome do usuário: " +
//                            usuario.name, Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getBaseContext(), "Falha: " + String.valueOf(code),
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Usuario> call, Throwable t) {
//                Toast.makeText(getBaseContext(), t.getMessage(),
//                        Toast.LENGTH_LONG).show();
//            }
//        });

        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("username", "admin");
            paramObject.put("password", "123456");

            Call<User> userCall = githubUser.getToken(paramObject.toString());
            userCall.enqueue(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        int code = response.code();
        if (code == 200) {
            User user = response.body();
            Toast.makeText(getBaseContext(), "Token: " +
                    user.Token, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), "Falha: " + response.body(),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {

    }

}
