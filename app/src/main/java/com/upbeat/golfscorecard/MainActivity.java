package com.upbeat.golfscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Hole[] mHoles = new Hole[18];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(android.R.id.list);

        int score = 0;
        for (int i = 0; i < mHoles.length; i++) {
            mHoles[i] = new Hole("Hole " + (i + 1) + " :", score);
        }

        HoleAdapter adapter = new HoleAdapter(mHoles, this);
        mListView.setAdapter(adapter);
    }
}
