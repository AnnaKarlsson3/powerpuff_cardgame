package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Action;
import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Hand;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAction {

    Action action;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        //action = new Action(selectedCardList);
    }

    @Test
    public void testInputPlayerName(){

        assertNotNull(action.playerName, "The name should not be null" );
    }



    @Test
    public void testChooseOneCard(){
        Hand hand = new Hand();
        int numberInHand = 4;

        Card card = action.findCardByNumber(numberInHand, hand);

        //assertEquals(card, hand.getCardsInHand().get(numberInHand-1) );

        assertNull(action.findCardByNumber(numberInHand, hand));
        System.out.println("the card from test" + card);


    }








    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }


}
