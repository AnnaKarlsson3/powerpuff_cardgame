package com.powerpuff.cardgame.cardGame;

public class Player {

    private int hp;
    private String name;
    private Hand hand;

    public Player(){
        hand = new Hand();
    }

    public Player(String name, int hp, Hand hand) {
        this.hp = hp;
        this.name = name;
        this.hand = new Hand();
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}