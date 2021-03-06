package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Hand {

    PlayerDeck playerDeck;
   public ArrayList<Card> cardsInHand;

    public Hand() {
        this.playerDeck = new PlayerDeck();
        ArrayList<Card> firstFiveCardsInDeck = (ArrayList<Card>) playerDeck.getPlayerCards().stream().limit(5).collect(Collectors.toList());
        setCardsInHand(firstFiveCardsInDeck);
        setPlayerDeck(removeCardsInHandFromDeck());
    }

    public PlayerDeck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(ArrayList<Card> updatedDeck) {
        playerDeck.setPlayerCards(updatedDeck);
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(ArrayList<Card> firstFiveInDeck) {
        this.cardsInHand = firstFiveInDeck;
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
        return playerDeck.getPlayerCards();
    }

    private Boolean removeOneCardFromPlayerDeck(Card c) {
        ArrayList<Card> cardsInDeck = playerDeck.getPlayerCards();
        cardsInDeck.remove(c);
        playerDeck.setPlayerCards(cardsInDeck);

        return false;
    }

    public Boolean deletePlayedCard(Card playedCard) {

        if (this.cardsInHand.contains(playedCard)) {
            this.cardsInHand.remove(playedCard);
            return true;
        }
        return false;
    }

}
