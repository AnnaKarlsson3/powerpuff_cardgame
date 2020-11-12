package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerDeck {

    public List<Card> playerCards = new ArrayList<>();
    public CardGenerator cardGenerator = new CardGenerator();
    public List<Card> commonDeck = cardGenerator.getCommonDeck();

    public PlayerDeck(){
        getCardsFromGeneratedCards();
        removeFromCommonDeck();
        System.out.println(commonDeck.size());
    }

    public List<Card> getCardsFromGeneratedCards() {
        playerCards = commonDeck.stream().limit(30).collect(Collectors.toList());
        return playerCards;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public List<Card> removeFromCommonDeck(){
        commonDeck.removeAll(playerCards);
        cardGenerator.setCommonDeck(commonDeck);
        return commonDeck;
    }


    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public void checkIfEmpty(){

    }
}
