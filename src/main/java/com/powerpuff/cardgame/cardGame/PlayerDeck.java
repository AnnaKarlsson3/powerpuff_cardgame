package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlayerDeck {

    public ArrayList<Card> playerCards = new ArrayList<>();
    public ArrayList<Card> commonDeck = CardGenerator.getInstance().getCommonDeck();
    public Boolean isEmpty;

    public PlayerDeck(){
        getCardsFromGeneratedCards();

    }

    public ArrayList<Card> getCardsFromGeneratedCards() {
        playerCards = (ArrayList<Card>) commonDeck.stream().limit(30).collect(Collectors.toList());
        removeFromCommonDeck(playerCards);
        return playerCards;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public ArrayList<Card> removeFromCommonDeck(ArrayList<Card> playerCardsFromGen){

        commonDeck.removeAll(playerCardsFromGen);
        CardGenerator.getInstance().setCommonDeck(commonDeck);
        return commonDeck;
    }


    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public boolean checkIfEmpty(ArrayList<Card> playerCards){
        if(playerCards == null){
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }
}
