package com.example.henrique.interactivestory.model;


public class Choice {


    private String mText;
    private int mNextPage;
    // Pontos dados pela escolha
    private int mPoints;
    // Pontos retirados pela escolha
    private int mPointsToUse;
    // Checa a existencia de pontos recebidos
    private boolean mGivePoints = false;
    // Checa a existencia de pontos a serem retirados
    private boolean mUsePoints = false;

    public Choice(String text, int nextPage) {
        mText = text;
        mNextPage = nextPage;
    }

    // Esse construtor serve para inicializar a classe com pontos
    public Choice(String text, int nextPage, int points) {
        mText = text;
        mNextPage = nextPage;
        mPoints = points;
        // Para checagem no StoryActivity
        mGivePoints = true;
    }

    public Choice(String text, int nextPage, int points, int pointsToUse) {
        mText = text;
        mNextPage = nextPage;
        mPoints = points;
        mPointsToUse = pointsToUse;
        mUsePoints = true;
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

    // Checagem para ver se a escolha lhe da pontos
    public boolean isPoints() {
        return mGivePoints;
    }

    public int getPointsToUse() {
        return mPointsToUse;
    }

    // Checagem para ver se a escolha lhe retira pontos
    public boolean isUsedPoints() {
        return mUsePoints;
    }



}
