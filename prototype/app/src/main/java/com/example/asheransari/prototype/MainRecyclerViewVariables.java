package com.example.asheransari.prototype;

import java.util.ArrayList;

/**
 * Created by asher.ansari on 5/18/2017.
 */

public class MainRecyclerViewVariables {
    private String title;
    private ArrayList<CardViewVariables> setCardViewItemArrayList;
    public MainRecyclerViewVariables(String title,ArrayList<CardViewVariables> arrayList)
    {
        this.title = title;
        this.setCardViewItemArrayList = arrayList;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<CardViewVariables> getCardViewItemArrayList() {
        return setCardViewItemArrayList;
    }

    public void setSetCardViewItemArrayList(ArrayList<CardViewVariables> setCardViewItemArrayList) {
        this.setCardViewItemArrayList = setCardViewItemArrayList;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
