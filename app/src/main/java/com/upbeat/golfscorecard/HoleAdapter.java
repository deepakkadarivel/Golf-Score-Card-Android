package com.upbeat.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class HoleAdapter extends BaseAdapter {

    private Hole[] mHoles;
    private Context mContext;

    public HoleAdapter(Hole[] holes, Context context) {
        mHoles = holes;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int i) {
        return mHoles[i];
    }

    @Override
    public long getItemId(int i) {
        return 0; //not implemented
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;



        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.hole_item, null);
            viewHolder = new ViewHolder();

            viewHolder.holeLabel = (TextView) view.findViewById(R.id.holeLabel);
            viewHolder.scoreLabel = (TextView) view.findViewById(R.id.holeScore);
            viewHolder.removeScoreButton = (Button) view.findViewById(R.id.removeScoreButton);
            viewHolder.addScoreButton = (Button) view.findViewById(R.id.addScoreButton);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

            viewHolder.holeLabel.setText(mHoles[i].getHoleName());
            viewHolder.scoreLabel.setText(mHoles[i].getScore() + "");

        viewHolder.addScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = mHoles[i].getScore() + 1;
                mHoles[i].setScore(score);
                viewHolder.scoreLabel.setText(score + "");
            }
        });

        viewHolder.removeScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHoles[i].getScore() <= 0) {
                    int score = 0;
                    mHoles[i].setScore(score);
                    viewHolder.scoreLabel.setText(score + "");
                } else {
                    int score = mHoles[i].getScore() - 1;
                    mHoles[i].setScore(score);
                    viewHolder.scoreLabel.setText(score + "");
                }
            }
        });

        return view;
    }

    private static class ViewHolder {
        private TextView holeLabel, scoreLabel;
        private Button removeScoreButton, addScoreButton;
    }
}