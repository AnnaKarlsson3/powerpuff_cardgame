package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Display;
import com.powerpuff.cardgame.cardGame.Game;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestDisplay {


    @Test
    public void testEnterNameMessage(){
        Display display = new Display();
        String actual = display.enterNameMessage;
        String expected = "Enter player name";

        assertEquals(actual, expected);

        assertEquals("failure - strings are not equal", actual, expected);
    }
}
