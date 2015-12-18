package com.example.henrique.interactivestory.list;

import android.widget.ImageView;

import com.example.henrique.interactivestory.ui.StoryActivity;

public class Stories {
    private int mImage;
    private String mTitle;
    private String mDescription;
    private Class mDestine;
    private String mButton = "Continuar";

    public Stories(int image, String title, String description, Class destine) {
        mImage = image;
        mTitle = title;
        mDescription = description;
        mDestine = destine;
    }

    public int getImage() {
        return mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public Class getDestine() {
        return mDestine;
    }

}
