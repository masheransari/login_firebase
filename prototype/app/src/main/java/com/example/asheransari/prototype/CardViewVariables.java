package com.example.asheransari.prototype;

import java.io.Serializable;

/**
 * Created by asher.ansari on 5/18/2017.
 */

public class CardViewVariables implements Serializable{
    private int ImageUrl;
    private String details;
    private String moreDetails;

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public String getMoreDetails() {
        return moreDetails;
    }

    public CardViewVariables(int imageUrl, String details, String moreDetails) {
        this.ImageUrl = imageUrl;
        this.details = details;
        this.moreDetails = moreDetails;
    }

    public int getImageUrl() {
        return ImageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setImageUrl(int imageUrl) {
        ImageUrl = imageUrl;
    }
}
