
import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestGameLogic {
    Game game;
    GameLogic gameLogic;

    @BeforeEach
    public void init() {
        game = new Game();
        gameLogic = new GameLogic();
    }


    @Test
    public void testAttack() {
        Computer computer = new Computer();
        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);

        int damage = attackCard.getPoint() - blockCard.getBlockPointPoint();
        assertEquals(2, attackCard.getPoint() - blockCard.getBlockPointPoint(), "answer should be 2");
        assertTrue(damage > blockCard.getBlockPointPoint(), "damage is greater than blockpoints");
            computer.setHp(damage);

    }

    @Test
    public void testIsCardFighter(){

        Player player = game.player;


        Card card1 = new Card("Action","actionCard",3,3);
        assertFalse(gameLogic.isCardFighter(card1,player),"isCardFighter should be false");


        int beforeBoardListSize = gameLogic.getGameboard().getPlayerActiveCards().size();

        Card card2 = new Card("Fighter","fighterCard",3,3);
        assertTrue(gameLogic.isCardFighter(card2,player),"isCardFighter should be true");

        int afterBoardListSize = gameLogic.getGameboard().getPlayerActiveCards().size();

        assertNotEquals(beforeBoardListSize,afterBoardListSize);
    }

    

}
