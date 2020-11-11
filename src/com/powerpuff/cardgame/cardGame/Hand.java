package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Hand {

    //PlayerDeck playerDeck;
    List<Card> cardsInHand = new ArrayList<Card>(5);

    public Hand(){
        //this.playerDeck = new PlayerDeck()
        //this.cardsInHand = setCardsInHand(playerDeck
        //        stream().limit(5).collect(Collectors.toList());
    }

    public ArrayList getCardsInHand() {
        return (ArrayList) cardsInHand;
    }

    public void setCardsInHand(List<Card> firstFiveInDeck) {
        //get first five elements out of the playersDeck
        this.cardsInHand = firstFiveInDeck;
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
