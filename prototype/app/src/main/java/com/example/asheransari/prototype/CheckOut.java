package com.example.asheransari.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CheckOut extends AppCompatActivity {

    private CardViewVariables cardViewVariables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Intent i = getIntent();
        cardViewVariables = (CardViewVariables) i.getSerializableExtra("data");
        Toast.makeText(this, ""+cardViewVariables.getMoreDetails(), Toast.LENGTH_SHORT).show();
    }
}
