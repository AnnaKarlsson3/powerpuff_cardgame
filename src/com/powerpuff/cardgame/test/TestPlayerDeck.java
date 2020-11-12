package com.powerpuff.cardgame.test;


import com.powerpuff.cardgame.cardGame.PlayerDeck;
import org.junit.jupiter.api.*;

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

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }

}
