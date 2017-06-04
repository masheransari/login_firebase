package com.example.asheransari.prototype;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.asheransari.prototype.Activities.MainActivity;
import com.example.asheransari.prototype.Authentication.signUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private Button login, signup, forget;
    private EditText username, psk;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    private void variableInit() {
        login = (Button) findViewById(R.id.btn_login);
        signup = (Button) findViewById(R.id.btn_signup_login);
        forget = (Button) findViewById(R.id.btn_forget_login);
        username = (EditText) findViewById(R.id.userName);
        psk = (EditText) findViewById(R.id.password_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_login);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        System.exit(0);
//        activi
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        variableInit();

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, com.example.asheransari.prototype.Authentication.forget.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, signUp.class);
                startActivity(i);
            }
        });
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString())) {
                    Toast.makeText(login.this, "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(psk.getText().toString())) {
                    Toast.makeText(login.this, "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(username.getText().toString(), psk.getText().toString()).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            Toast.makeText(login.this, "Authentication fail,, Please Check your Email and password..", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(login.this, "Login Successfull....!!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(login.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                });
            }
        });

    }
}
