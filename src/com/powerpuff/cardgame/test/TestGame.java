package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGame {

    @Test
    public void testStartGame(){
        Game game = new Game();
        assertTrue(!game.gameOver);
    }

    @Test
    public void testGameOver(){
        Game game = new Game();

          if (game.hp == 0 || game.playerDeckList.size() == 0){
                assertTrue(game.gameOver);
            }
            else{
                assertFalse(game.gameOver);
          }
        }

    }


    @Test
    public void testEndGame(){
        Game game = new Game();
        assertFalse(game.gameOver);
    }

}
