package com.powerpuff.cardgame.cardGame;

public class Card {
    private String type;
    private int point;

    public Card(String type, int point) {
        this.type = type;
        this.point = point;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
