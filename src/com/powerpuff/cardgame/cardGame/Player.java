package com.powerpuff.cardgame.cardGame;

public class Player {

    private int hp = 20;
    private String name;
    private Hand hand;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public Hand getHand() {
        return hand;
    }
}
