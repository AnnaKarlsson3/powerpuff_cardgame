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
    public int attack(Player opponent, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCards) {
        damage = 0;


        return damage;

    }

    public void block(Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCard) {

    }


}
