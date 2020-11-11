package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class TestGame {

    @Test
    public void testStartGame(){
        Game game = new Game();
        assertTrue(!game.gameOver);
    }

    @Test
    public void testGameOver(){
        Game game = new Game();
         int hp = 0;
         

            if (hp == 0){
                assertTrue(game.gameOver);
            }
        }

    }


