package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    PlayerDeck playerDeck;
    ArrayList<Card> cardsInHand;

    public Hand() {
        this.playerDeck = new PlayerDeck();
        List<Card> firstFiveCardsInDeck = playerDeck.getPlayerCards().stream().limit(5).collect(Collectors.toList());
        setCardsInHand(firstFiveCardsInDeck);
    }

    public PlayerDeck getPlayerDeck() {
        return playerDeck;
    }

    public ArrayList getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> firstFiveInDeck) {
        this.cardsInHand = (ArrayList<Card>) firstFiveInDeck;
    }

    public Boolean addNewCardToHand(){

        return false;

    }

    public Boolean removeOneCardFromPlayerDeck(Card c) {

        return false;
    }

    public void displayCardsInHand() {
        //print/show the cards thru display onto gameboard
    }

    public void deletePlayedCard(Card playedCard) {
        //delete the card the player chose to play
    }

}
