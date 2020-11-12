package com.powerpuff.cardgame.test;


import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.PlayerDeck;
import org.junit.jupiter.api.*;
import java.util.List;
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
        playerDeck.removeFromCommonDeck();
        assertFalse(playerDeck.commonDeck.containsAll(playerDeck.playerCards));
    }

    @Test
    void testCheckIfEmpty(){
        List<Card> playerCardstest = null;
        assertEquals(true, playerDeck.checkIfEmpty(playerCardstest));
    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }

}
