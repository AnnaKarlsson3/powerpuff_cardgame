package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Gameboard {
    ArrayList<Card> playerActiveCards;
    ArrayList<Card> computerActiveCards;

    public Gameboard() {
        this.playerActiveCards = new ArrayList<>();
        this.computerActiveCards = new ArrayList<>();
    }

    public ArrayList<Card> getPlayerActiveCards() {
        return playerActiveCards;
    }

    public void setPlayerActiveCards(ArrayList<Card> playerActiveCards) {
        this.playerActiveCards = playerActiveCards;
    }

    public ArrayList<Card> getComputerActiveCards() {
        return computerActiveCards;
    }

    public void setComputerActiveCards(ArrayList<Card> computerActiveCards) {
        this.computerActiveCards = computerActiveCards;
    }

    public Card placePlayerCardOnGameboard(Card card){
        playerActiveCards.add(card);
        setPlayerActiveCards(playerActiveCards);
        return card;
    }

    public Card placeComputerCardOnGameboard(Card card){
        computerActiveCards.add(card);
        return card;
    }
}
