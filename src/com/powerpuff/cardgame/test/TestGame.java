package com.powerpuff.cardgame.test;


import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Player;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;



public class TestGame {
    Game game;

    @BeforeEach
    public void init(){
        game = new Game();

    }

    @Test
    public void testStartGame(){
        //Game game = new Game();
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
        //Game game = new Game();
        game.randomStart();
        int counter = game.counter;
        System.out.println(counter);
        assertTrue(counter <= 1, "counter is 0 or 1");
    }

    @Test
    public void testGameTurn(){
        //Game game = new Game();



    }



    @Test
    public void testEndGame(){
        //Game game = new Game();
        assertFalse(game.gameOver);
    }

    @Test
    public void testUpdateHp(){
        Player player = new Player();
        player.setHp(20);
        Card playersCard = new Card("Action","hi",3);
        Card opponentsCard = new Card("Fighter","Hello",2);
        assertEquals(21,game.updateHp(player,playersCard,opponentsCard));


    }

}
