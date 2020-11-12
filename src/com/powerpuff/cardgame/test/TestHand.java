package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Hand;

import static org.junit.jupiter.api.Assertions.*;

import com.powerpuff.cardgame.cardGame.PlayerDeck;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestHand {

    Hand testHand;

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach executed");
        testHand = new Hand();
    }

    @Test
    public void testCardsInHand() {
        System.out.println("=== Test for cards in hand executed ===");

        PlayerDeck playersDeck = testHand.getPlayerDeck();
        ArrayList<Card> cardsInHand = testHand.getCardsInHand();
        List<Card> firstFiveCardsInDeck = playersDeck.getPlayerCards().stream().limit(5).collect(Collectors.toList());

        assertArrayEquals(firstFiveCardsInDeck.toArray(), cardsInHand.toArray());
        assertEquals(5, cardsInHand.size());
    }

    @Test
    public void testAddNewCardToHand(){
        ArrayList<Card> cardsBeforeRemovedOne = testHand.getPlayerDeck().getPlayerCards();
        int sizeBeforeRemove = cardsBeforeRemovedOne.size();

        if(cardsBeforeRemovedOne.isEmpty()){
            assertFalse(testHand.addNewCardToHand());

        }else{
            assertTrue(testHand.addNewCardToHand());
            ArrayList<Card> cardsAfterRemovedOne = testHand.getPlayerDeck().getPlayerCards();
            assertFalse(sizeBeforeRemove == cardsAfterRemovedOne.size());
        }
    }


    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
    }


}
