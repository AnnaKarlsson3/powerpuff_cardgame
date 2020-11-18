package com.powerpuff.cardgame.cardGame;

public class GameLogic {

    private Gameboard gameboard = new Gameboard();


    public Boolean isCardFighter(Card playedCard, Player player) {
        if (playedCard.getType().equals("Action")) {
            player.setHp(player.getHp() + playedCard.getPoint());
            player.getHand().deletePlayedCard(playedCard);
            player.getHand().addNewCardToHand();
            return false;
        } else {
            gameboard.placePlayerCardOnGameboard(playedCard);
            return true;
        }

    }

    public void attack(Computer computer, Card attack, Card block) {
        int damage = attack.getPoint() - block.getBlockPointPoint();
        if (damage > block.getBlockPointPoint())
            computer.setHp(computer.getHp() - damage);
            //blockMethod();
        else if (damage < block.getBlockPointPoint() || damage == 0) {
            // blockMethod();
        }
    }

    public Gameboard getGameboard() {
        return gameboard;
    }


}
