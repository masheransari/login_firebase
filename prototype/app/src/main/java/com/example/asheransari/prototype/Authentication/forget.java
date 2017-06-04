package com.example.asheransari.prototype.Authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asheransari.prototype.R;
import com.example.asheransari.prototype.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forget extends AppCompatActivity {
    private EditText email;
    private Button forgetbtn, loginbtn;
    private FirebaseAuth mAuth;

    private void variableInit() {
        email = (EditText) findViewById(R.id.userName_forget);
        forgetbtn = (Button) findViewById(R.id.forgetbtn_forget);
        loginbtn = (Button) findViewById(R.id.btn_forget_login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        variableInit();
        mAuth = FirebaseAuth.getInstance();
        final Intent i = new Intent(forget.this, login.class);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
                finish();
            }
        });
        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText().toString())) {
                    Toast.makeText(forget.this, "Please Enter Email First..**", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(forget.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(forget.this, "Please Check Your Internet Connection.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(forget.this, "Please Check Your Email First..**", Toast.LENGTH_SHORT).show();
                            startActivity(i);
                            finish();
                        }
                    }
                });
            }
        });

    }
}
