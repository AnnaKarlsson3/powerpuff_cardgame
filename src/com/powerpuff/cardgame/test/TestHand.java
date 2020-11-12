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
    ArrayList<Card> cardsInHand;

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach executed");
        testHand = new Hand();
        cardsInHand = testHand.getCardsInHand();
    }

    @Test
    public void testCardsInHand() {
        System.out.println("=== Test for cards in hand executed ===");

        assertEquals(5, cardsInHand.size());
    }

    @Test
    public void testRemoveCardsInHandFromDeck(){
        System.out.println("=== Test for removing cards in hand from deck ===");

        ArrayList<Card> updatedDeck = testHand.removeCardsInHandFromDeck();
        assertFalse(updatedDeck.containsAll(cardsInHand));
    }

    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
    }


}
