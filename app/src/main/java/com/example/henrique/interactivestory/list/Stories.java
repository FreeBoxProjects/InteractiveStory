package com.example.henrique.interactivestory.list;

public class Stories {
    private String mTitle;
    private String mDescription;
    private String mButton = "Continuar";

    public Stories(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }


}
