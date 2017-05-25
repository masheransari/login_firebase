package com.example.asheransari.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity /*implements onItemClickInterface*/ {

    private RecyclerView recyclerView;
    private FirebaseAuth firebaseAuth;
    private ArrayList<MainRecyclerViewVariables> arrayList = new ArrayList<>();

    private void preparedData() {
        String[] items = null;
        int[] ImageUrl = new int[5];
        String[] detailData = null;
        for (int i = 0; i < 4; i++) {
            String category = null;
            items = fillDatas(i);
            ImageUrl = getImageUrl(i);
            String item = detailsProducts(i);
            detailData = item.split(",");
            switch (i) {
                case 0: //Electronic Items.
                    category = "Electronics";
                    break;
                case 1: //Mobiles.
                    category = "Mobiles";
                    break;
                case 2: //Laptops.
                    category = "laptops";
                    break;
                default: //Cloths.
                    category = "Cloths";
                    break;
            }
            ArrayList<CardViewVariables> variablesArrayList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                variablesArrayList.add(new CardViewVariables(ImageUrl[j], items[j], detailData[j]));
            }
            arrayList.add(new MainRecyclerViewVariables(category, variablesArrayList));
        }
    }


    private int[] getImageUrl(int item) {
        int[] imageUrl = new int[5];
        switch (item) {
            case 0:
                imageUrl[0] = R.drawable.iron;
                imageUrl[1] = R.drawable.washing;
                imageUrl[2] = R.drawable.deep_freezer;
                imageUrl[3] = R.drawable.ac;
                imageUrl[4] = R.drawable.fan;
                break;
            case 1:
                imageUrl[0] = R.drawable.lg_mobile;
                imageUrl[1] = R.drawable.samsung_mobile;
                imageUrl[2] = R.drawable.iphone_mobile;
                imageUrl[3] = R.drawable.infnix_mobile;
                imageUrl[4] = R.drawable.htc_mobile;
                break;
            case 2:
                imageUrl[0] = R.drawable.hp_laptop;
                imageUrl[1] = R.drawable.dell_laptop;
                imageUrl[2] = R.drawable.mac_laptop;
                imageUrl[3] = R.drawable.lenovo_laptop;
                imageUrl[4] = R.drawable.toshiba_laptop;
                break;
            default:
                imageUrl[0] = R.drawable.islamiat_book;
                imageUrl[1] = R.drawable.english_book;
                imageUrl[2] = R.drawable.math_book;
                imageUrl[3] = R.drawable.programming_book;
                imageUrl[4] = R.drawable.networing_book;
                break;

        }

        return imageUrl;
    }

    private String[] fillDatas(int itemNumber) {
        String[] data = null;
        String tempData = null;
        switch (itemNumber) {
            case 0:
                tempData = "Iron,Washing Mashine,Deep Freezer,AC,Fan";
                break;
            case 1:
                tempData = "LG,Samsung,IPhone,Infnix,HTC";
                break;
            case 2:
                tempData = "HP,Dell,Apple(Mac),Lenevo,Toshiba";
                break;
            default:
                tempData = "Islamiat,English,Maths,Programming,Networking";
                break;
        }
        for (int i = 0; i < 5; i++) {
            data = tempData.split(",");
        }
        return data;
    }

    private String detailsProducts(int item) {
        String details = null;
        switch (item) {
            case 0:
                details = "we have different type of iron machine you can get order best iron machine with manageable price.," +
                        "we have different type of Washing machine you can get order best Washing machine with manageable price.," +
                        "we have different type of Deep Freezer you can get order best Deep Freezer with manageable price.," +
                        "we have different type of Air Condition you can get order best Air Condition with manageable price.," +
                        "we have different type of Fan machine you can get order best Fan with manageable price.";
                break;
            case 1:                /*tempData = "LG,Samsung,IPhone,Infnix,HTC";*/
                details = "LG brand is most sellable in market. You can get best mobile with high Specification with greater Discount in our application.," +
                        "SAMSUNG brand is most sellable in market. You can get best mobile with high Specification with greater Discount in our application.," +
                        "IPHONE brand is most sellable in market. You can get best mobile with high Specification with greater Discount in our application.," +
                        "INFINIX brand is most sellable in market. You can get best mobile with high Specification with greater Discount in our application.," +
                        "OPPO brand is most sellable in market. You can get best mobile with high Specification with greater Discount in our application.";
                break;
            case 2:
                details = "Hp Laptops are availables in suitables prices.. you can get laptops in cheep prices.," +
                        "Hp Laptops are availables in suitables prices.. you can get laptops in cheep prices.," +
                        "Apple Laptops are availables in suitables prices.. you can get laptops in cheep prices.," +
                        "lenovo Laptops are availables in suitables prices.. you can get laptops in cheep prices.," +
                        "Toshiba Laptops are availables in suitables prices.. you can get laptops in cheep prices.";
                break;
            default:                /*tempData = "Islamiat,English,Maths,Programming,Networking";*/
                details = "We have Best Islamic Books with famous Book Author with fair Pricing with Discount as well.," +
                        "We have Best English Books with famous Book Author with fair Pricing with Discount as well.," +
                        "We have Best Maths Books with famous Book Author with fair Pricing with Discount as well.," +
                        "We have Best Programmings Books with famous Book Author with fair Pricing with Discount as well.," +
                        "We have Best Networkings Books with famous Book Author with fair Pricing with Discount as well.";
                break;
        }
        return details;
    }

    private void initVariable() {
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariable();
        firebaseAuth = FirebaseAuth.getInstance();
        preparedData();
        recyclerView.setHasFixedSize(true);
        RecyclerViewMainAdapter adapter = new RecyclerViewMainAdapter(this, arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
//        adapter.setClickListner(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        System.exit(0);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_activity_ment,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        switch (id){
            case R.id.map_screen:
//                return true;
                Intent i = new Intent(MainActivity.this, map.class);
                startActivity(i);
                break;
            case R.id.signoutData:
                firebaseAuth.signOut();
                Intent j = new Intent(MainActivity.this, login.class);
                startActivity(j);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //    @Override
//    public void onClick(View v, int position) {
//        Toast.makeText(this, "Detais : "+arrayList.get(position).getCardViewItemArrayList().get(position).getMoreDetails(), Toast.LENGTH_SHORT).show();
//    }


//    private void initArrayList() {
//        for (int i = 0; i < 5; i++) {
//            ArrayList<CardViewVariables> cardViewVariables = new ArrayList<>();
//            for (int j = 0; j < 6; j++) {
//                cardViewVariables.add(new CardViewVariables(android.R.drawable.ic_lock_idle_alarm, ""));
//                cardViewVariables.add(new CardViewVariables(android.R.drawable.ic_lock_idle_alarm, "asd"));
//                cardViewVariables.add(new CardViewVariables(android.R.drawable.ic_lock_idle_alarm, "asd"));
//                cardViewVariables.add(new CardViewVariables(android.R.drawable.ic_lock_idle_alarm, "asd"));
//                cardViewVariables.add(new CardViewVariables(android.R.drawable.ic_lock_idle_alarm, "asd"));
//                cardViewVariables.add(new CardViewVariables(android.R.drawable.ic_lock_idle_alarm, "asd"));
//            }
//            arrayList.add(new MainRecyclerViewVariables("Electronic " + i, cardViewVariables));
//        }
//    }
}
