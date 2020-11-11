package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Game;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestGame {

    @Test
    public void testStartGame(){
        Game game = new Game();
        assertTrue(!game.gameOver);
    }

    @Test
    public void testEndGame(){
        Game game = new Game();
        assertFalse(game.gameOver);
    }

}
