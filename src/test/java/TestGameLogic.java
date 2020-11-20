
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

        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);
        Card attackCard2 = new Card("Fighter", "Kristi", 2, 2);
        Card blockCard2 = new Card("Fighter", "Berit", 5,5);

        ArrayList<Card> playerActiveCards = gameboard.playerActiveCards;
        playerActiveCards.add(attackCard);
        playerActiveCards.add(attackCard2);
        ArrayList<Card> playerActiveCardsCopy = (ArrayList<Card>) playerActiveCards.clone();

        ArrayList<Card> computerActiveCards = gameboard.computerActiveCards;
        computerActiveCards.add(blockCard);
        computerActiveCards.add(blockCard2);
        ArrayList<Card> computerActiveCardsCopy = (ArrayList<Card>) computerActiveCards.clone();

        assertArrayEquals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertEquals(1,  gameLogic.block(attackCard, blockCard, playerActiveCards, computerActiveCards), "hpDamage should be 1");
        assertTrue(gameLogic.greater == attackCard.getPoint() > blockCard.getBlockPointPoint(), "attackpoints are greater than blockpoints");
        assertFalse(Arrays.equals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray()), "Expected both not to be equal");

        //--------------------

        assertArrayEquals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertEquals(3,  gameLogic.block(attackCard2, blockCard2, playerActiveCards, computerActiveCards), "hpDamage should be 3");
        assertTrue(gameLogic.less == attackCard2.getPoint() < blockCard2.getBlockPointPoint(), "attackpoints are less than blockpoints");

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
