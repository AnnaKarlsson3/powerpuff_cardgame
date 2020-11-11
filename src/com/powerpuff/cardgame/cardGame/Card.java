package com.powerpuff.cardgame.cardGame;

public class Card {
    private String type;
    private String name;
    private int point;

    public Card(String type, String name, int point) {
        this.type = type;
        this.name = name;
        this.point = point;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Card{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
