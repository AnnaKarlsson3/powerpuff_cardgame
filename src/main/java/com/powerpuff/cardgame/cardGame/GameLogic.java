package com.powerpuff.cardgame.cardGame;

public class GameLogic {

    private Gameboard gameboard = new Gameboard();


    public String checkCardType(Card playedCard, Player player) {
        return "";
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
