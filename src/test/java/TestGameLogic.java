
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
        computer.setHp(20);
        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);

        int damage = attackCard.getPoint() - blockCard.getBlockPointPoint();
        assertEquals(2, attackCard.getPoint() - blockCard.getBlockPointPoint(), "answer should be 2");
        assertTrue(damage > blockCard.getBlockPointPoint(), "damage is greater than blockpoints");
            computer.setHp(computer.getHp() - damage);

        Card attackCard2 = new Card("Fighter", "Lola", 1, 1);
        Card blockCard2 = new Card("Fighter", "Dora", 1,1);

        int damage2 = attackCard2.getPoint() - blockCard2.getBlockPointPoint();
        assertEquals(0, attackCard2.getPoint() - blockCard2.getBlockPointPoint(), "answer should be 0");
        assertTrue(damage2  == 0, "damage should be 0");
        //call blockMethod

        Card attackCard3 = new Card("Fighter", "Lola", 1, 1);
        Card blockCard3 = new Card("Fighter", "Karlada", 3,3);

        int damage3 = attackCard3.getPoint() - blockCard3.getBlockPointPoint();
        assertEquals(-2, attackCard3.getPoint() - blockCard3.getBlockPointPoint(), "answer should be -2");
        assertTrue(damage < blockCard3.getBlockPointPoint(), "damage is less than blockpoints");
        //call blockMethod

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
