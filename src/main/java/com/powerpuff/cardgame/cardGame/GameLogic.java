package com.powerpuff.cardgame.cardGame;

public class GameLogic {


    public void attack(Card attack, Card block) {
    }

    Gameboard gameboard = new Gameboard();

    public Boolean IsCardFighter(Card playedCard, Player player){
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


}
