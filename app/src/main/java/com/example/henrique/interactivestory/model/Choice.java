package com.example.henrique.interactivestory.model;


public class Choice {


    private String mText;
    private int mNextPage;
    private int mPoints;
    private boolean mGivePoints = false;

    public Choice(String text, int nextPage) {
        mText = text;
        mNextPage = nextPage;
    }

    public Choice(String text, int nextPage, int points) {
        mText = text;
        mNextPage = nextPage;
        mPoints = points;
        mGivePoints = true;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }

    public int getPoints() {
        return mPoints;
    }

    public boolean isPoints() {
        return mGivePoints;
    }


}
