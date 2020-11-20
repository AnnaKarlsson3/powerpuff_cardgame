
import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TestGameLogic {
    Game game;
    GameLogic gameLogic;
    Gameboard gameboard;

    @BeforeEach
    public void init() {
        game = new Game();
        gameLogic = new GameLogic();
        gameboard = new Gameboard();
    }

    @Test
    public void testAttack() {
        Computer computer = new Computer();
        computer.setHp(20);
        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);

        assertEquals(18,  gameLogic.attack(computer, attackCard, blockCard, gameboard.getPlayerActiveCards(), gameboard.getComputerActiveCards()), "hpDamage should be 18");
        assertTrue(gameLogic.damage == 2, "damage should be 2");
        assertTrue(gameLogic.greater == attackCard.getPoint() > blockCard.getBlockPointPoint(), "attackpoints are greater than blockpoints");

//-----------------------

        Card attackCard3 = new Card("Fighter", "Lola", 1, 1);
        Card blockCard3 = new Card("Fighter", "Karlada", 3,3);
        computer.setHp(20);

        assertEquals(20,  gameLogic.attack(computer, attackCard3, blockCard3, gameboard.getPlayerActiveCards(), gameboard.getComputerActiveCards()), "hpDamage should be 20");
    }

    @Test
    public void testBlock(){



    }




    @Test
    public void testCheckCardType() {

        Player player = game.player;


        Card card1 = new Card("Action", "actionCard", 3, 3);
        Card card2 = new Card("Fighter", "fighterCard", 3, 3);
        int beforeBoardListSize = game.gameboard.getPlayerActiveCards().size();
        assertAll(
                () -> assertEquals("Action", gameLogic.manageSelectedCardFromHand(card1, player, game.gameboard)),
                () -> assertEquals("Fighter", gameLogic.manageSelectedCardFromHand(card2, player, game.gameboard))

        );
        int afterBoardListSize = game.gameboard.getPlayerActiveCards().size();
        assertNotEquals(beforeBoardListSize,afterBoardListSize);

    }




}
