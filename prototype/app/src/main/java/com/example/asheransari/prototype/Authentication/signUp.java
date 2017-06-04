package com.example.asheransari.prototype.Authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asheransari.prototype.Activities.MainActivity;
import com.example.asheransari.prototype.R;
import com.example.asheransari.prototype.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {

    private EditText email, psk, repsk;
    private Button create, loginbtn;
    private FirebaseAuth mAuth;

    private void variableInit() {
        email = (EditText) findViewById(R.id.email_signUp);
        psk = (EditText) findViewById(R.id.psk_signUp);
        repsk = (EditText) findViewById(R.id.repsk_signUp);
        create = (Button) findViewById(R.id.createAccount_signup);
        loginbtn = (Button) findViewById(R.id.loginBtn_signup);
    }

    private boolean checkPskMatch() {
        if (psk.getText().toString().equals(repsk.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        variableInit();
//        final Intent i = null;
        mAuth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signUp.this, login.class);
                startActivity(i);
                finish();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPskMatch()) {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), psk.getText().toString()).addOnCompleteListener(signUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(signUp.this, "Please Check Your Email is Correct.. \nor\n Check Your Network Status..!!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(signUp.this, "Account has been created..!!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(signUp.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    });
                } else {
                    Toast.makeText(signUp.this, "Password Mismatches...", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
