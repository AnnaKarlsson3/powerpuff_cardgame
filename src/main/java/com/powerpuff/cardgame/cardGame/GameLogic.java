package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class GameLogic {




    public String manageSelectedCard(Card playedCard, Player player, Gameboard gameboard) {

        return "";

    }

    public void attack(Player computer, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> computerActiveCards){
        int damage  = attack.getPoint() - block.getBlockPointPoint();
        if(attack.getPoint() > block.getBlockPointPoint()) {
            computer.setHp(computer.getHp() - damage);
            block(attack, block, playerActiveCards, computerActiveCards);
        }
        else {
            block(attack, block, playerActiveCards, computerActiveCards);
        }
    }

    public void block (Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> computerActiveCards){
        if(attack.getPoint() > block.getBlockPointPoint()){
            computerActiveCards.remove(block);
        }
        else if(attack.getPoint() < block.getBlockPointPoint()){
            block.setBlockPoint(block.getBlockPointPoint() - attack.getPoint());
            playerActiveCards.remove(attack);

        }
        else{
            computerActiveCards.remove(block);
            playerActiveCards.remove(attack);
        }
    }






}
