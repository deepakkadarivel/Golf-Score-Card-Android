package com.upbeat.golfscorecard;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Hole[] mHoles = new Hole[18];
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String PREFS_FILE = "com.upbeat.golfscorecard.preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mListView = (ListView) findViewById(android.R.id.list);

        int score = 0;
        for (int i = 0; i < mHoles.length; i++) {
            score = mSharedPreferences.getInt("HOLE"+i, score);
            mHoles[i] = new Hole("Hole " + (i + 1) + " :", score);
        }

        HoleAdapter adapter = new HoleAdapter(mHoles, this);
        mListView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < mHoles.length; i++) {
            mEditor.putInt("HOLE" + i, mHoles[i].getScore());
        }
        mEditor.apply();
    }
}
