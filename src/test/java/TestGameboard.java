import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGameboard {

    Gameboard board;

    @BeforeEach
    public void init() {
        System.out.println("@BeforeEch TestGameBoard");

        board = new Gameboard();
    }


    @Test
    public void testAddPlayedCardsToBoard() {
        Hand hand = new Hand();
        Card card = new Card("Action", "action1", 3, 3);
        Card playedCard = board.placePlayerCardOnGameboard(card);

        assertNotNull(playedCard);
        assertEquals(card, playedCard);
    }

    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
        CardGenerator.getInstance().setCommonDeck(CardGenerator.getInstance().generateCardsAndGet());

    }






}
