package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Gameboard {
    public ArrayList<Card> playerActiveCards;
    public ArrayList<Card> computerActiveCards;

    public Gameboard() {
        this.playerActiveCards = new ArrayList<>();
        this.computerActiveCards = new ArrayList<>();
    }

    public ArrayList<Card> getPlayerActiveCards() {
        return playerActiveCards;
    }

    public ArrayList<Card> getComputerActiveCards() {
        return computerActiveCards;
    }

    public void setComputerActiveCards(ArrayList<Card> computerActiveCards) {
        this.computerActiveCards = computerActiveCards;
    }


    public Card placePlayerCardOnGameboard(Card card){
        playerActiveCards.add(card);
        return card;
    }

    public Card placeComputerCardOnGameboard(Card card){
        computerActiveCards.add(card);
        return card;
    }

}
