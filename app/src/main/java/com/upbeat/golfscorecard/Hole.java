package com.upbeat.golfscorecard;

public class Hole {

    private String holeName;
    private int score;

    public Hole(String holeName, int score) {
        this.holeName = holeName;
        this.score = score;
    }

    public String getHoleName() {
        return holeName;
    }

    public void setHoleName(String holeName) {
        this.holeName = holeName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
