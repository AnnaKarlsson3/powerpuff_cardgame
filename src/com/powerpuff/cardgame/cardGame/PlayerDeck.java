package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerDeck {

    private ArrayList<Card> playerCards = new ArrayList<Card>();

    public PlayerDeck(){
        getCardsFromGeneratedCards();

    }

    public List<Card> getCardsFromGeneratedCards() {
        CardGenerator cardgen = new CardGenerator();
        List<Card> commonDeck = cardgen.getCommonDeck();
        List<Card> playerCards = commonDeck.stream().limit(30).collect(Collectors.toList());;
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
