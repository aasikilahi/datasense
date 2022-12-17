package com.example.datasense.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datasense.databinding.ActivitySpalshBinding;


public class SplashActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    private static final int SPLASH_TIME_OUT = 2500;
    ActivitySpalshBinding binding;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpalshBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        sp = getApplicationContext()
                .getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        new Handler().postDelayed(() -> {

            if (sp.getBoolean("login_already", true)) {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }


        }, SPLASH_TIME_OUT);
    }
}

