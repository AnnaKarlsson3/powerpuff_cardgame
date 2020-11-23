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
        assertTrue(!game.gameOver);
    }

    @Test
    public void testGameOver() {
        Player player = new Player();
        Computer computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        ArrayList<Card> playerHand = player.getHand().getCardsInHand();
        ArrayList<Card> playerHandEmpty = (ArrayList<Card>) player.getHand().getCardsInHand().clone();

        ArrayList<Card> computerHand = computer.getHand().getCardsInHand();
        ArrayList<Card> computerHandEmpty = (ArrayList<Card>) computer.getHand().getCardsInHand().clone();

        assertArrayEquals(computerHand.toArray(), computerHandEmpty.toArray(), "Expected both to be equal");
        computerHandEmpty.clear();
        assertFalse(Arrays.equals(computerHand.toArray(), computerHandEmpty.toArray()), "Expected both not to be equal");

        assertArrayEquals(playerHand.toArray(), playerHandEmpty.toArray(), "Expected both to be equal");
        playerHandEmpty.clear();
        assertFalse(Arrays.equals(playerHand.toArray(), playerHandEmpty.toArray()), "Expected both not to be equal");
        player.setHp(0);

        assertTrue(playerHandEmpty.size() == 0, "should be true");
        assertTrue(player.getHp() <= 0, "should be true");


        assertTrue(game.gameOver(playerHandEmpty, player.getHp(), computerHandEmpty, computer.getHp()), "gameover should return true");

//-------------------------------------------



    }

    @Test
    public void testEndGame() {
        assertFalse(game.gameOver);
    }

//    @Test
//    public void testUpdateHpOfPlayer() {
//        Player player = game.player;
//        Computer computer = game.computer;
//        int computerHpBeforeUpdate = computer.getHp();
//        Card playedCard1 = new Card("Action", "apple", 3, 5);
//        assertEquals(player.getHp() + 3, game.updateHpIfPlayersTurn(playedCard1));
//
//        Card playedCard2 = new Card("Fighter", "Orange", 5, 5);
//        game.updateHpIfPlayersTurn(playedCard2);
//        assertFalse(computerHpBeforeUpdate == computer.getHp());
//
//    }
//
//    @Test
//    public void testUpdateHpOfComputer() {
//        Player player = game.player;
//        Computer computer = game.computer;
//        int playerHpBeforeUpdate = player.getHp();
//        Card playedCard = new Card("Action", "hello", 5, 5);
//        assertEquals(computer.getHp() + 5, game.updateHpIfComputersTurn(playedCard));
//
//        Card playedCard2 = new Card("Fighter", "Hi", 3, 5);
//        game.updateHpIfComputersTurn(playedCard2);
//        assertFalse(playerHpBeforeUpdate == player.getHp());
//
//    }

    @Test
    public void testCreateNewGame(){
        try {
            new Game();
        } catch (Exception ex) {
            fail();
        }
        Game game = new Game();
        assertFalse(game.gameOver);

    }

}
