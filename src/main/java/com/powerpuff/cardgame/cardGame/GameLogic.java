package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class GameLogic {

    Display display = new Display();

    public String manageSelectedCard(Card playedCard, Player player, Gameboard gameboard) {
        if (playedCard.getType().equals("Action")) {
            player.setHp(player.getHp() + playedCard.getPoint());
            display.printAddHpForPlayer(playedCard.getPoint());
        } else {
            gameboard.placePlayerCardOnGameboard(playedCard);
        }
        player.getHand().deletePlayedCard(playedCard);
        player.getHand().addNewCardToHand();
        return playedCard.getType();

    }

    public int damage;
    public boolean greater;
    public boolean less;

    public int attack(Player attacker, Player blocker, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> blockersActiveCards) {
        damage = attack.getPoint() - block.getBlockPointPoint();
        greater = attack.getPoint() > block.getBlockPointPoint();
        if (greater) {
            blocker.setHp(blocker.getHp() - damage);
            block(attacker, blocker, attack, block, playerActiveCards, blockersActiveCards);
        } else {
            block(attacker, blocker, attack, block, playerActiveCards, blockersActiveCards);
        }
        return blocker.getHp();
    }

    public int block(Player attacker, Player blocker, Card attack, Card block, ArrayList<Card> playerActiveCards, ArrayList<Card> blockersActiveCards) {
        greater = attack.getPoint() > block.getBlockPointPoint() && block.getPoint() < attack.getBlockPointPoint();
        less = attack.getPoint() < block.getBlockPointPoint() && block.getPoint() > attack.getBlockPointPoint();
        if (greater) {
            blockersActiveCards.remove(block);
            display.printCardIsDead(blocker.getName(), block.getName());
        } else if (less) {
            block.setBlockPoint(block.getBlockPointPoint() - attack.getPoint());
            playerActiveCards.remove(attack);
            display.printCardIsDead(attacker.getName(), attack.getName());
            display.blockPointReduced(blocker.getName(),block.getName(),block.getBlockPointPoint());

        } else {
            blockersActiveCards.remove(block);
            playerActiveCards.remove(attack);
            display.printBothCardDead(attack.getName(), block.getName());
        }
        return block.getBlockPointPoint();
    }
}
