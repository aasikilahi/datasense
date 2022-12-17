package com.example.datasense.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datasense.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    ActivityLoginBinding loginBinding;
    FirebaseAuth mAuth;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        sp = getApplicationContext()
                .getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();
        if (sp.getBoolean("login_already", true)) {
            String eMail = sp.getString("eMail", "");
            String passWord = sp.getString("passWord", "");
            loginBinding.etEmailAddress.setText(eMail);
            loginBinding.etPassword.setText(passWord);
        } else {
            loginBinding.etEmailAddress.setText("");
            loginBinding.etPassword.setText("");
        }

        loginBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserAccount();
            }


        });
    }

    private void loginUserAccount() {// show the visibility of progress bar to show loading
        loginBinding.progressBar.setVisibility(View.VISIBLE);

        String email, password;
        email = loginBinding.etEmailAddress.getText().toString();
        password = loginBinding.etPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                                    "Login successful!!",
                                                    Toast.LENGTH_LONG)
                                            .show();

                                    loginBinding.progressBar.setVisibility(View.GONE);

                                    SharedPreferences.Editor myEdit = sp.edit();
                                    myEdit.putString("eMail", email);
                                    myEdit.putString("passWord", password);

                                    myEdit.commit();
                                    Intent intent
                                            = new Intent(LoginActivity.this,
                                            SelectMatrixActivity.class);
                                    startActivity(intent);
                                } else {

                                    Toast.makeText(getApplicationContext(),
                                                    "Login failed!!",
                                                    Toast.LENGTH_LONG)
                                            .show();

                                    loginBinding.progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
    }
}