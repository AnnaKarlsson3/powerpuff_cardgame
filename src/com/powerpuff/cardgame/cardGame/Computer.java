package com.powerpuff.cardgame.cardGame;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Computer extends Player{

    public Computer() {
        super.setName("Opponent");

    }

    public Computer(String name, int hp, Hand hand) {
        super(name, hp, hand);
    }

    public Card playCard() {
        return null;
    }




}
