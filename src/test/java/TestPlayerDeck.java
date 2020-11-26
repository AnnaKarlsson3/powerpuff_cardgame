import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.PlayerDeck;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestPlayerDeck {
    PlayerDeck playerDeck;
    Game game;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        playerDeck = new PlayerDeck();
        game = new Game();
    }

    @Test
    void testPlayerDeckLength(){
        assertEquals( 30, playerDeck.getCardsFromGeneratedCards(game.cardGenerator).size());
    }

    @Test
    void testRemoveFromCommonDeck(){
        playerDeck.getCardsFromGeneratedCards(game.cardGenerator);
        assertFalse(game.cardGenerator.getCommonDeck().containsAll(playerDeck.playerCards));
        System.out.println(game.cardGenerator.getCommonDeck().size());
    }

    @Test
    void testCheckIfEmpty(){
        ArrayList<Card> playerCardstest = null;
        assertTrue(playerDeck.checkIfEmpty(playerCardstest));

    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }

}
