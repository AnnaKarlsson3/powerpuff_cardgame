package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
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
    public void testPlayerName(){
       display.playerNameTurn();

        String actual = display.playerNameTurn;
        String expected = " it´s your turn!" ;

        assertEquals(  expected, actual);
    }

    @Test
    public void testPrintPlayerHpMessage(){
        display.printPlayerHpMessage();
        String actual = display.playerHp;
        String expected = "Player HP is: ";

        assertEquals(  expected, actual);
    }

    @Test
    public void testDisplayCardsInHandLength(){
      Hand hand = new Hand();
      assertTrue(hand.getCardsInHand().toArray().length == 5);
    }


    @Test
    public void testNumerationOfCardsInHand(){
        Hand hand = new Hand();

        List<String> numberedCards = display.addNumberCardsInHand(hand.getCardsInHand());

               List<String> cardNumbers = numberedCards
                        .stream()
                        .map(card -> card.substring(0, 1))
                        .collect(Collectors.toList());

        List<String> listOfNumbers = Stream.of("1", "2", "3", "4", "5")
                .collect(Collectors.toList());

        assertEquals(listOfNumbers, cardNumbers);
    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }
}
