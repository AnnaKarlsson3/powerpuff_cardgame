package com.powerpuff.cardgame.cardGame;

public class Player {

    public int hp;
    public String name;
    public Hand hand;

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

    public String setName(String name) {
        this.name = name;
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

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}