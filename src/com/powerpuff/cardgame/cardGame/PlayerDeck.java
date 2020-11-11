package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class PlayerDeck {

    private ArrayList<Card> PlayerCards = new ArrayList<Card>();

    public PlayerDeck(){
        PlayerCards.add(new Card("fighter", "Card 1", 2));
        PlayerCards.add(new Card("fighter", "Card 2", 5));
        PlayerCards.add(new Card("fighter", "Card 3", 1));
        PlayerCards.add(new Card("fighter", "Card 4", 3));
        PlayerCards.add(new Card("fighter", "Card 5", 2));
        PlayerCards.add(new Card("fighter", "Card 6", 2));
        PlayerCards.add(new Card("fighter", "Card 7", 1));
        PlayerCards.add(new Card("fighter", "Card 8", 2));
        PlayerCards.add(new Card("fighter", "Card 9", 2));
        PlayerCards.add(new Card("fighter", "Card 11", 2));
        PlayerCards.add(new Card("fighter", "Card 12", 2));
        PlayerCards.add(new Card("fighter", "Card 13", 3));
        PlayerCards.add(new Card("fighter", "Card 14", 2));
        PlayerCards.add(new Card("fighter", "Card 15", 1));
        PlayerCards.add(new Card("fighter", "Card 16", 2));
        PlayerCards.add(new Card("fighter", "Card 17", 2));
        PlayerCards.add(new Card("fighter", "Card 18", 2));
        PlayerCards.add(new Card("fighter", "Card 19", 1));
        PlayerCards.add(new Card("fighter", "Card 20", 2));
        PlayerCards.add(new Card("fighter", "Card 21", 2));
        PlayerCards.add(new Card("fighter", "Card 22", 2));
        PlayerCards.add(new Card("fighter", "Card 23", 2));
        PlayerCards.add(new Card("action", "Card 24", 2));
        PlayerCards.add(new Card("action", "Card 25", 3));
        PlayerCards.add(new Card("action", "Card 26", 2));
        PlayerCards.add(new Card("action", "Card 27", 5));
        PlayerCards.add(new Card("action", "Card 28", 2));
        PlayerCards.add(new Card("action", "Card 29", 1));
        PlayerCards.add(new Card("action", "Card 30", 1));

    }

    public ArrayList<Card> getPlayerCards() {
        return PlayerCards;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        PlayerCards = playerCards;
    }
}
