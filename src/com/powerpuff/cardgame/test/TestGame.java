package com.powerpuff.cardgame.test;


import com.powerpuff.cardgame.cardGame.Game;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;



public class TestGame {

    @Test
    public void testStartGame(){
        Game game = new Game();
        assertTrue(!game.gameOver);
    }

    @Test
    public void testGameOver(){
        int hp = 0;
        ArrayList<Object> playerDeckList = new ArrayList<>();

        BooleanSupplier condition = () -> hp == 0 || playerDeckList.size() == 0;

                assertTrue(condition, "boolean gameover should be true");
        }


    @Test
    public void testRandomStart(){
        //test if math.random gives 0 or 1 in first Turn!
        Game game = new Game();
        game.randomStart();
        int counter = game.counter;
        System.out.println(counter);
        assertTrue(counter <= 1, "counter is 0 or 1");
    }

    @Test
    public void testGameTurn(){
        Game game = new Game();



    }



    @Test
    public void testEndGame(){
        Game game = new Game();
        assertFalse(game.gameOver);
    }

}
