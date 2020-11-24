package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class GameLogic {

    Display display = new Display();

    public String manageSelectedCard(Card playedCard, Player player, Gameboard gameboard) {
        if (playedCard.getType().equals("Action")) {
            player.setHp(player.getHp() + playedCard.getPoint());
            display.printaddHp(playedCard.getPoint());
        } else {
            gameboard.placePlayerCardOnGameboard(playedCard);
        }
        player.getHand().deletePlayedCard(playedCard);
        player.getHand().addNewCardToHand();
        return playedCard.getType();
        //return "";

    }

    public int damage;
    public boolean greater;
    public boolean less;

    public int attack(Player opponent, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCards) {
        damage = attack.getPoint() - block.getBlockPointPoint();
        greater = attack.getPoint() > block.getBlockPointPoint();
        if(greater){
            opponent.setHp(opponent.getHp() - damage);
            block(attack, block, playerActiveCards, opponentActiveCards);
        }else {
            block(attack, block, playerActiveCards, opponentActiveCards);
        }
        return opponent.getHp();
    }

    public int block(Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> opponentActiveCards) {
        greater = attack.getPoint() > block.getBlockPointPoint() && block.getPoint() < attack.getBlockPointPoint();
        less = attack.getPoint() < block.getBlockPointPoint() && block.getPoint() > attack.getBlockPointPoint();
        if(greater){
            opponentActiveCards.remove(block);
            System.out.println("Opponent '" + block.getName() + "'  is dead.\n");
        }else if(less){
                block.setBlockPoint(block.getBlockPointPoint() - attack.getPoint());
                playerActiveCards.remove(attack);
                System.out.println("Your Fighter '" + attack.getName() + "' is dead.");
                System.out.println("Opponent '" +block.getName() + "' Block points is now " + block.getBlockPointPoint());

        }
         else {
            opponentActiveCards.remove(block);
            playerActiveCards.remove(attack);
            System.out.println("Both your fighter '" + attack.getName() + "' and the opponent '" + block.getName() + "' are dead.");
        }
        return block.getBlockPointPoint();
    }
}
