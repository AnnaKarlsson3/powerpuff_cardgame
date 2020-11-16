package com.powerpuff.cardgame.test;


import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Computer;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Player;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;


public class TestGame {
    Game game;

    @BeforeEach
    public void init() {
        game = new Game();

    }

    @Test
    public void testStartGame() {
        //Game game = new Game();
        assertTrue(!game.gameOver);
    }

    @Test
    public void testGameOver() {
        boolean gameover = false;
        int hp = 0;
        Player player = new Player();
        ArrayList<Card> playerHand = player.getHand().getCardsInHand();
        ArrayList<Card> playerHandEmpty = (ArrayList<Card>) player.getHand().getCardsInHand().clone();

        Assertions.assertArrayEquals(playerHand.toArray(), playerHandEmpty.toArray(), "Expected both to be equal");

        playerHandEmpty.clear();

        assertFalse(Arrays.equals(playerHand.toArray(), playerHandEmpty.toArray()), "Expected both not to be equal");

        BooleanSupplier condition = () -> hp == 0 || playerHandEmpty.size() == 0;
        assertTrue(condition, "should be true");

        //if condition is true, set boolean to true
        gameover = true;

        assertTrue(gameover == true);


    }


    @Test
    public void testRandomStart() {
        //test if math.random gives 0 or 1 in first Turn!
        //Game game = new Game();
        game.randomStart();
        int counter = game.counter;
        System.out.println(counter);
        assertTrue(counter <= 1, "counter is 0 or 1");
    }

    @Test
    public void testEndGame() {
        //Game game = new Game();
        assertFalse(game.gameOver);
    }

//    @Test
//    public void testUpdateHp() {
//        Player player = new Player();
//        player.setHp(20);
//        Card playersCard = new Card("Action", "hi", 3);
//        Card opponentsCard = new Card("Fighter", "Hello", 2);
//        assertEquals(21, game.updateHp(player, playersCard, opponentsCard));
//    }

    @Test
    public void testUpdateHpOfPlayer() {
        Player player = game.player;
        Computer computer = game.computer;
        int computerHpBeforeUpdate = computer.getHp();
        Card playedCard1 = new Card("Action", "apple", 3);
        assertEquals(player.getHp() + 3, game.updateHpOfPlayer(playedCard1));

        Card playedCard2 = new Card("Fighter", "Orange", 5);
        game.updateHpOfPlayer(playedCard2);
        assertFalse(computerHpBeforeUpdate == computer.getHp());

    }

    @Test
    public void testUpdateHpOfComputer() {
        Player player = game.player;
        Computer computer = game.computer;
        int playerHpBeforeUpdate = player.getHp();
        Card playedCard = new Card("Action", "hello", 5);
        assertEquals(computer.getHp() + 5, game.updateHpOfComputer(playedCard));

        Card playedCard2 = new Card("Fighter", "Hi", 3);
        game.updateHpOfComputer(playedCard2);
        assertFalse(playerHpBeforeUpdate == player.getHp());

    }

}
