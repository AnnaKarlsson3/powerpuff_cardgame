package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerDeck {

    public ArrayList<Card> playerCards = new ArrayList<>();
    public CardGenerator cardGenerator = new CardGenerator();
    public ArrayList<Card> commonDeck = cardGenerator.getCommonDeck();
    public Boolean isEmpty;

    public PlayerDeck(){
        getCardsFromGeneratedCards();
        removeFromCommonDeck();
        System.out.println(commonDeck.size());
    }

    public ArrayList<Card> getCardsFromGeneratedCards() {
        playerCards = (ArrayList<Card>) commonDeck.stream().limit(30).collect(Collectors.toList());
        return playerCards;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public List<Card> removeFromCommonDeck(){
        commonDeck.removeAll(playerCards);
        cardGenerator.setCommonDeck((ArrayList<Card>) commonDeck);
        return commonDeck;
    }


    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public boolean checkIfEmpty(List<Card> playerCards){
        if(playerCards == null){
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }
}
