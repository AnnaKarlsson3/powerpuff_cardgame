package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;

public class PlayerDeck {

    private ArrayList<Card> PlayerCards = new ArrayList<Card>();

    public PlayerDeck(){
        getCardsFromGeneratedCards();

    }

    public List<Card> getCardsFromGeneratedCards() {
        return null;
    }

    public ArrayList<Card> getPlayerCards() {
        return PlayerCards;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        PlayerCards = playerCards;
    }

    public void checkIfEmpty(){

    }
}
