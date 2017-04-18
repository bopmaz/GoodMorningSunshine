package com.bopmaster.goodmorningsunshine.apiCall;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tuanm on 18-Apr-17.
 */

public class QuoteOfTheDay {

    private int ID;
    private String title;
    private String content;
    private String link;

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }
}
