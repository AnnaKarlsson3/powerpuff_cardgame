package com.powerpuff.cardgame.test;


import com.powerpuff.cardgame.cardGame.PlayerDeck;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestPlayerDeck {
    PlayerDeck playerDeck;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        playerDeck = new PlayerDeck();
    }

    @Test
    void testPlayerDeckLength(){
        Assertions.assertEquals( 30, playerDeck.getCardsFromGeneratedCards().size());
    }

    @Test
    void testRemoveFromCommonDeck(){
        playerDeck.removeFromCommonDeck();
        Assertions.assertFalse(playerDeck.commonDeck.containsAll(playerDeck.playerCards));
    }


    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }

}
