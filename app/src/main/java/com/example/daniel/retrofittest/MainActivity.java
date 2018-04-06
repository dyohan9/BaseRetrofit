package com.example.daniel.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.daniel.retrofittest.Utils.Retrofit.Login.RetrofitLogin;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new RetrofitLogin(this, "admin", "123456");
    }
}
