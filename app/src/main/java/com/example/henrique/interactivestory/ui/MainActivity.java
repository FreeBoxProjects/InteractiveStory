package com.example.henrique.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.henrique.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameFild;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameFild = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameFild.getText().toString();
                startStory(name);
            }
        });

    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        // Utilizamos o getString para pegar a string nos valores strings.xml
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
        mNameFild.setText("");
    }



}

