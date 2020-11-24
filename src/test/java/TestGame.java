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
