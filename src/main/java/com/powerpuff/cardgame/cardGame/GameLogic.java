package com.powerpuff.cardgame.cardGame;

public class GameLogic {
    private Gameboard gameboard = new Gameboard();


    public void attack(Card attack, Card block) {

    }

    public Boolean isCardFighter(Card playedCard, Player player) {
        if(playedCard.getType().equals("Action")){
            player.setHp(player.getHp() + playedCard.getPoint());
            player.getHand().deletePlayedCard(playedCard);
            player.getHand().addNewCardToHand();
            return false;
        }else{
            gameboard.placePlayerCardOnGameboard(playedCard);
            return true;
        }

    }

    public Gameboard getGameboard() {
        return gameboard;
    }


}
