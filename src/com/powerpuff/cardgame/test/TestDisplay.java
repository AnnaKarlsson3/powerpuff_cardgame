package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.*;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestDisplay {

    Display display;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        display = new Display();
    }

    @Test
    public void testEnterNameMessage(){
        String actual = display.enterNameMessage;
        String expected = "Enter player name:";

        assertEquals(  expected, actual);
    }

    @Test
    public void testPrintPlayerHpMessage(){
        Player player = new Player();
        int hp = player.getHp();

        String actual = display.playerHp;
        String expected = "Player HP is: " + hp;

        assertEquals(  expected, actual);
    }

    @Test
    public void testDisplayCardsInHandLength(){
      Hand hand = new Hand();
      assertTrue(hand.getCardsInHand().toArray().length == 5);
    }

    @Test
    public void testDisplayCardsInHandPrint(){
        Hand hand = new Hand();
        ArrayList cards = hand.getCardsInHand();
        ArrayList actual = display.getCardsInHand(hand.getCardsInHand());
        ArrayList expected = cards;
        assertEquals(expected, actual);
    }

    @Test
    public void testNumerationOfCardsInHand(){
        List<String> steamCardsNumbers =
                display.addNumberCardsInHand()
                        .stream()
                        .filter(card -> card.matches("[1-5].")).filter(card -> card.matches("[0-5]"))
                        .collect(Collectors.toList());

        List<String> listOfNumbers = Stream.of("1", "2", "3", "4", "5")
                .collect(Collectors.toList());

        assertEquals(steamCardsNumbers, listOfNumbers);

    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }
}
