package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class GameLogic {


    public String checkCardType(Card playedCard){
        return playedCard.getType();
    }


    public void attack(Computer computer, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> computerActiveCards){
        int damage = attack.getPoint() - block.getBlockPointPoint();
        if(damage > block.getBlockPointPoint()) {
            computer.setHp(computer.getHp() - damage);
            block(attack, block, playerActiveCards, computerActiveCards);
        }
        else {
           block(attack, block, playerActiveCards, computerActiveCards);
        }
    }

    public void block (Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> computerActiveCards){

    }



}
