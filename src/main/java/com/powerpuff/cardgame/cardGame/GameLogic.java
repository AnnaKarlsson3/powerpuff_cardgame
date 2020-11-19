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

    public void attack(Player opponent, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCards) {

        if (attack.getPoint() > block.getBlockPointPoint()) {
            int damage = attack.getPoint() - block.getBlockPointPoint();
            opponent.setHp(opponent.getHp() - damage);
            System.out.println(opponent.getName() + "'s '" + block.getName() + "'  is dead\n");
            block(attack, block, playerActiveCards, opponentActiveCards);
        } else if (attack.getPoint() < block.getBlockPointPoint()) {
            System.out.println("'"+attack.getName() + "' is dead");
            block(attack, block, playerActiveCards, opponentActiveCards);

        } else {
            System.out.println(" both attack card '" + attack.getName() + "' and block card '" + block.getName() + "' are dead");
            opponentActiveCards.remove(block);
            playerActiveCards.remove(attack);
        }
    }

    public void block(Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCard) {
        if (attack.getPoint() > block.getBlockPointPoint()) {

            opponentActiveCard.remove(block);
        } else if (attack.getPoint() < block.getBlockPointPoint()) {
            block.setBlockPoint(block.getBlockPointPoint() - attack.getPoint());
            playerActiveCards.remove(attack);

        }
    }


}
