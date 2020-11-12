package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Action;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestAction {

    Action action;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        action = new Action();
    }

    @Test
    public void testInputPlayerName(){

        assertNotNull(action.playerName, "The name should not be null" );
        assertTrue(action.playerName.length() > 0, "Name should not be empty (longer than 0)");
    }


    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }


}
