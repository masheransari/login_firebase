package com.example.asheransari.prototype.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.asheransari.prototype.R;
import com.example.asheransari.prototype.Variable.CardViewVariables;

public class CheckOut extends AppCompatActivity {

    private CardViewVariables cardViewVariables;
    private TextView name, detail;
    ImageView mImageView;
    Button button;

    private void variableInit(){
        name = (TextView)findViewById(R.id.nameChcekout);
        detail = (TextView)findViewById(R.id.detailCheckOut);
        mImageView = (ImageView)findViewById(R.id.imageViewCheckout);
        button = (Button)findViewById(R.id.checkoutbtn);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Intent i = getIntent();
        variableInit();
        cardViewVariables = (CardViewVariables) i.getSerializableExtra("data");
        Toast.makeText(this, ""+cardViewVariables.getMoreDetails(), Toast.LENGTH_SHORT).show();

        Glide.with(this)
                .load(cardViewVariables.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(mImageView);
        name.setText(cardViewVariables.getDetails());
        detail.setText(cardViewVariables.getMoreDetails());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CheckOut.this, MainActivity.class);
                Toast.makeText(CheckOut.this, cardViewVariables.getDetails()+" has been checkout..!!", Toast.LENGTH_SHORT).show();
                startActivity(i);
                finish();
            }
        });


    }
}
