package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;

public class PlayerDeck {

    private ArrayList<Card> playerCards = new ArrayList<Card>();

    public PlayerDeck(){
        getCardsFromGeneratedCards();

    }

    public List<Card> getCardsFromGeneratedCards() {
        return playerCards;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public void checkIfEmpty(){

    }
}
