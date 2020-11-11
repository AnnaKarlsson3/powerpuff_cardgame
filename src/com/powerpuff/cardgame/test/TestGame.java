package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Game;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGame {

    @Test
    public void testStartGame(){
        Game game = new Game();
        assertTrue(!game.gameOver);
    }

}
