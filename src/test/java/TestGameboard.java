import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Gameboard;
import com.powerpuff.cardgame.cardGame.Hand;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGameboard {

    Gameboard board;
    Game game;
    Hand hand;

    @BeforeEach
    public void init() {

        board = new Gameboard();
        game = new Game();
        hand = game.player.getHand();

    }


    @Test
    public void testAddPlayedCardsToBoard() {
        Card card = hand.getCardsInHand().get(0);
        Card playedCard = board.placePlayerCardOnGameboard(card);

        assertNotNull(playedCard);
        assertEquals(card, playedCard);
    }






}
