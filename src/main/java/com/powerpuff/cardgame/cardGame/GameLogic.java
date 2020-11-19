package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class GameLogic {

    private Gameboard gameboard = new Gameboard();


    public String checkCardType(Card playedCard, Player player) {
        if (playedCard.getType().equals("Action")) {
            player.setHp(player.getHp() + playedCard.getPoint());
            player.getHand().deletePlayedCard(playedCard);
            player.getHand().addNewCardToHand();
        } else {
            gameboard.placePlayerCardOnGameboard(playedCard);
        }
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


    public Gameboard getGameboard() {
        return gameboard;
    }


}
