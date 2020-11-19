
import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void testBlock(){

        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);
        Card attackCard2 = new Card("Fighter", "Kristi", 2, 2);
        Card blockCard2 = new Card("Fighter", "Berit", 5,5);
        Card attackCard3 = new Card("Fighter", "Crush", 2, 2);
        Card blockCard3 = new Card("Fighter", "crain", 2,2);

        ArrayList<Card> playerActiveCards = new ArrayList<>();
        playerActiveCards.add(attackCard);
        playerActiveCards.add(attackCard2);
        playerActiveCards.add(attackCard3);
        ArrayList<Card> playerActiveCardsCopy = (ArrayList<Card>) playerActiveCards.clone();

        ArrayList<Card> computerActiveCards = new ArrayList<>();
        computerActiveCards.add(blockCard);
        computerActiveCards.add(blockCard2);
        computerActiveCards.add(blockCard3);
        ArrayList<Card> computerActiveCardsCopy = (ArrayList<Card>) computerActiveCards.clone();


        assertTrue(computerActiveCards != null, "should not be null");
        assertArrayEquals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertTrue(attackCard.getPoint() > blockCard.getBlockPointPoint(), "attack points should be greater than blockpoints");
        computerActiveCards.remove(blockCard);
        assertFalse(Arrays.equals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray()), "Expected both not to be equal");


        assertTrue(playerActiveCards != null, "should not be null");
        assertArrayEquals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertTrue(attackCard2.getPoint() < blockCard2.getBlockPointPoint(), "attack points should be less than blockpoints");
        blockCard2.setBlockPoint(blockCard2.getBlockPointPoint() - attackCard2.getPoint());

        playerActiveCards.remove(attackCard2);
        assertFalse(Arrays.equals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray()), "Expected both not to be equal");

//----------------------
        playerActiveCardsCopy.remove(attackCard2);
        assertArrayEquals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray(), "Expected both to be equal");
        computerActiveCardsCopy.remove(blockCard);
        assertArrayEquals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray(), "Expected both to be equal");

        assertTrue(attackCard3.getPoint() == blockCard3.getBlockPointPoint(), "attack points should be equal to blockpoints");
        playerActiveCards.remove(attackCard3);
        computerActiveCards.remove(blockCard3);
        assertFalse(Arrays.equals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray()), "Expected both not to be equal");
        assertFalse(Arrays.equals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray()), "Expected both not to be equal");

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
