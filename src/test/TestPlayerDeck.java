package com.powerpuff.cardgame.test;


import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.PlayerDeck;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestPlayerDeck {
    PlayerDeck playerDeck;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        playerDeck = new PlayerDeck();
    }

    @Test
    void testPlayerDeckLength(){
        assertEquals( 30, playerDeck.getCardsFromGeneratedCards().size());
    }

    @Test
    void testRemoveFromCommonDeck(){
        playerDeck.getCardsFromGeneratedCards();
        assertFalse(playerDeck.commonDeck.containsAll(playerDeck.playerCards));
        System.out.println(playerDeck.commonDeck.size());
    }

    @Test
    void testCheckIfEmpty(){
        ArrayList<Card> playerCardstest = null;
        assertTrue(playerDeck.checkIfEmpty(playerCardstest));

    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }

}
