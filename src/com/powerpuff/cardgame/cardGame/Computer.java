package com.powerpuff.cardgame.cardGame;

public class Computer extends Player{

    public Computer() {
        super.setName("Opponent");

    }

    public Computer(String name, int hp, Hand hand) {
        super(name = "Opponent", hp, hand);
    }




}
