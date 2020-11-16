package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Action;
import com.powerpuff.cardgame.cardGame.Card;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
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
    public void testSelectedCard(){
        Action action = null;

        Card selectedcard = new Card("Fighter", "CoolCard", 10);
        List<Card> selectedCardList = new ArrayList<>();
        selectedCardList.add(selectedcard);

        try{
            action = new Action(selectedCardList);
        } catch (Exception ex){
            fail();
        }

        assertNotEquals(1, selectedCardList.size());

    }




    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }


}
