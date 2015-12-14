package com.example.henrique.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private Page mCurrentPage;
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

        loadPage(0);
    }

    private void loadPage(int atualPage) {
        mCurrentPage = mStory.getPage(atualPage);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        mPointsView.setText(mPlayer.getPoints());

        if (mCurrentPage.isFinal()){
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
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    boolean isPoints = mCurrentPage.getChoice1().isPoints();
                    if (isPoints) {
                        int points = mCurrentPage.getChoice1().getPoints();
                        mPlayer.addPoints(points);
                    }
                    mPlayer.setPage(nextPage);
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    boolean isPoints = mCurrentPage.getChoice2().isPoints();
                    if (isPoints) {
                        int points = mCurrentPage.getChoice2().getPoints();
                        mPlayer.addPoints(points);
                    }
                    loadPage(nextPage);
                }
            });
        }


    }


}
