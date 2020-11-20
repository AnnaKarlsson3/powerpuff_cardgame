package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class GameLogic {


    public String manageSelectedCardFromHand(Card playedCard, Player player, Gameboard gameboard) {
        if (playedCard.getType().equals("Action")) {
            player.setHp(player.getHp() + playedCard.getPoint());

        } else {
            gameboard.placePlayerCardOnGameboard(playedCard);
        }
        player.getHand().deletePlayedCard(playedCard);
        player.getHand().addNewCardToHand();
        return playedCard.getType();

    }

    public int damage;
    public boolean greater;


    public int attack(Player opponent, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCards) {
        damage = attack.getPoint() - block.getBlockPointPoint();
        greater = attack.getPoint() > block.getBlockPointPoint();
        if(greater){
            opponent.setHp(opponent.getHp() - damage);

            System.out.println(opponent.getName() + "'s '" + block.getName() + "'  is dead\n");
           // block(attack, block, playerActiveCards, opponentActiveCards);
        }

        return opponent.getHp();

    }

    public void block(Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCard) {

    }


}
