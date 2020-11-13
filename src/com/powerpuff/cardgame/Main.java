package com.powerpuff.cardgame;


import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Player;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //new Game().run();

        Player player = new Player();
        player.getHand().getPlayerDeck().getCardsFromGeneratedCards();
        List<Card> playerDeckList = player.getHand().getPlayerDeck().getPlayerCards();

        //PlayerDeck deck = new PlayerDeck();
        //System.out.println(deck.getCardsFromGeneratedCards());

        System.out.println(playerDeckList);


    }
}
