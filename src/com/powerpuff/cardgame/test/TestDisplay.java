package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Display;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Hand;
import com.powerpuff.cardgame.cardGame.Player;
import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
    public void testDisplayCardsInHandPrint(){
        Hand hand = new Hand();
        ArrayList cards = hand.getCardsInHand();
        ArrayList actual = display.getCardsInHand(hand.getCardsInHand());
        ArrayList expected = cards;
        assertEquals(expected, actual);
    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }
}
