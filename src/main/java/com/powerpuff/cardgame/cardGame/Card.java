package com.powerpuff.cardgame.cardGame;

public class Card {
    private String type;
    private String name;
    private int point;
    private int blockPoint;

    public Card(String type, String name, int point, int blockPoint) {
        this.type = type;
        this.name = name;
        this.point = point;
        this.blockPoint = blockPoint;
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

    public int getBlockPointPoint() {
        return blockPoint;
    }

    public void setBlockPoint(int blockPoint) {
        this.blockPoint = blockPoint;
    }

    @Override
    public String toString() {
        return "Card{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", point=" + point + '\'' +
                ", blockpoint=" + blockPoint +
                '}';
    }
}
