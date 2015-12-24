package com.example.henrique.interactivestory.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henrique.interactivestory.R;
import com.example.henrique.interactivestory.model.Page;
import com.example.henrique.interactivestory.model.Player;
import com.example.henrique.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private TextView mPointsView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mPage;
    private int mCurrentPage = 0;
    private int mPoints = 0;
    private Player mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mPointsView = (TextView)findViewById(R.id.pointsCount);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);
        mPointsView = (TextView)findViewById(R.id.pointsCount);

        mPlayer = new Player();

        loadPage(mCurrentPage);
    }

    private void loadPage(int atualPage) {
        mPage = mStory.getPage(atualPage);

        Drawable drawable = getResources().getDrawable(mPage.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mPage.getText();
        mTextView.setText(pageText);

        mPointsView.setText(mPoints + "");

        if (mPage.isFinal()){
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        else {
            mChoice1.setText(mPage.getChoice1().getText());
            mChoice2.setText(mPage.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mPage.getChoice1().getNextPage();
                    boolean isPoints = mPage.getChoice1().isPoints();
                    boolean isPointsToUse = mPage.getChoice1().isUsedPoints();
                    int points = 0;
                    if (isPoints) {
                        int addPoints = mPage.getChoice1().getPoints();
                        points += addPoints;
                    }

                    if (isPointsToUse) {
                        int usePoints = mPage.getChoice1().getPointsToUse();
                        if (mPoints >= usePoints) {
                            points -= usePoints;
                        } else {
                            // Dizer ao usuário que ele não possui pontos suficientes
                        }

                    }
                    saveData(nextPage, points);
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mPage.getChoice2().getNextPage();
                    boolean isPoints = mPage.getChoice2().isPoints();
                    boolean isPointsToUse = mPage.getChoice2().isUsedPoints();
                    int points = 0;
                    if (isPoints) {
                        int addPoints = mPage.getChoice2().getPoints();
                        points += addPoints;
                    }

                    if (isPointsToUse) {
                        int usePoints = mPage.getChoice2().getPointsToUse();
                        if(mPoints >= usePoints) {
                            points -= usePoints;
                        }
                    } else {
                        // Dizer ao usuário que ele não possui pontos suficientes
                    }
                    saveData(nextPage, points);
                    loadPage(nextPage);
                }
            });
        }


    }


    public void saveData(int page, int points) {
        SharedPreferences sharedPreference = getSharedPreferences("story_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putInt("page", page);
        editor.putInt("points", points);
        editor.apply();

        mCurrentPage = sharedPreference.getInt("page", 0);
        mPlayer.setPage(mCurrentPage);
        int addPoints = sharedPreference.getInt("points", 0);
        mPoints += addPoints;
        mPlayer.addPoints(addPoints);

    }


}
