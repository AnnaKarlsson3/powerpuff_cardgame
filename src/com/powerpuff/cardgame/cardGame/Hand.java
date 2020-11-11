package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Hand {

    //PlayerDeck playersDeck = new PlayersDeck();
    ArrayList cardsInHand = new ArrayList(5);

    public ArrayList getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(ArrayList cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public void addNewCardToHand(){
        //in the end/beginning of a turn
    }

    public void displayCardsInHand(){
        //print/show the cards thru display onto gameboard
    }

    public void deletePlayedCard(Card playedCard){
        //delete the card the player chose to play
    }

}
