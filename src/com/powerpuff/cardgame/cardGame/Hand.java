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
        setPlayerDeck(removeCardsInHandFromDeck());
    }

    public PlayerDeck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(ArrayList<Card> updatedDeck) {
        playerDeck.setPlayerCards(updatedDeck);
    }

    public ArrayList getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> firstFiveInDeck) {
        this.cardsInHand = (ArrayList<Card>) firstFiveInDeck;
    }

    public Boolean addNewCardToHand() {
        ArrayList<Card> cardsInDeck = playerDeck.getPlayerCards();
        if (!cardsInDeck.isEmpty()) {
            Card newCard = cardsInDeck.get(0);
            cardsInHand.add(newCard);
            removeOneCardFromPlayerDeck(newCard);
            return true;
        }
        return false;
    }

    public ArrayList<Card> removeCardsInHandFromDeck() {
        playerDeck.getPlayerCards().removeAll(cardsInHand);
        return (ArrayList<Card>) playerDeck.getPlayerCards();
    }

    private Boolean removeOneCardFromPlayerDeck(Card c) {
        List<Card> cardsInDeck = playerDeck.getPlayerCards();
        cardsInDeck.remove(c);
        playerDeck.setPlayerCards((ArrayList<Card>) cardsInDeck);

        return false;
    }

    public void displayCardsInHand(){
        //print names of the cards player is holding
    }


    public void deletePlayedCard(Card playedCard) {
        //delete the card the player chose to play
    }

}
