package com.example.henrique.interactivestory.model;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.henrique.interactivestory.R;

public class Player {

    private int mCurrentPage = 0;
    private int mPoints = 0;

    public Player() {

    }

    public void addPoints(int points) {
        mPoints += points;
    }

    public void setPoints(int points) {
        mPoints = points;
    }

    public String getPoints() {
        return mPoints + "";
    }

    public void setPage(int page) {
        mCurrentPage = page;
    }

    public int getCurrentPage() {
        return mCurrentPage;
    }


}
