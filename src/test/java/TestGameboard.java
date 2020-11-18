import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Gameboard;
import com.powerpuff.cardgame.cardGame.Hand;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGameboard {

    Gameboard board;

    @BeforeEach
    public void init() {
        board = new Gameboard();
    }

    @Test
    public void testAddPlayedCardsToBoard() {
        Hand hand = new Hand();
        Card card = (Card) hand.getCardsInHand().get(0);
        Card playedCard = board.placePlayerCardOnGameboard(card);

        assertNotNull(playedCard);
        assertEquals(card, playedCard);
    }




}
