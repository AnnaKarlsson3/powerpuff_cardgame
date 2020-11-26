import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TestGameLogic {
    GameLogic gameLogic;
    Gameboard gameboard;


    @BeforeEach
    public void init() {
        System.out.println("@BeforeEach TestGameLogic");
        gameLogic = new GameLogic();
        gameboard = new Gameboard();


    }

    @Test
    public void testAttack() {
        Player attacker = new Player();
        attacker.setName("mockAttacker");
        Computer computer = new Computer();
        computer.setHp(20);
        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);

        assertEquals(18,  gameLogic.attack(attacker,computer, attackCard, blockCard, gameboard.getPlayerActiveCards(), gameboard.getComputerActiveCards()), "hpDamage should be 18");
        assertTrue(gameLogic.damage == 2, "damage should be 2");
        assertTrue(gameLogic.greater == attackCard.getPoint() > blockCard.getBlockPointPoint(), "attackpoints are greater than blockpoints");

//-----------------------

        Card attackCard3 = new Card("Fighter", "Lola", 1, 1);
        Card blockCard3 = new Card("Fighter", "Karlada", 3,3);
        computer.setHp(20);

        assertEquals(20,  gameLogic.attack(attacker,computer, attackCard3, blockCard3, gameboard.getPlayerActiveCards(), gameboard.getComputerActiveCards()), "hpDamage should be 20");
    }

    @Test
    public void testBlock(){
        Computer blocker = new Computer();
        Player attacker = new Player();
        attacker.setName("mockBlocker");

        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);
        Card attackCard2 = new Card("Fighter", "Kristi", 2, 2);
        Card blockCard2 = new Card("Fighter", "Berit", 5,5);
        Card attackCard3 = new Card("Fighter", "Crush", 2, 2);
        Card blockCard3 = new Card("Fighter", "crain", 2,2);

        ArrayList<Card> playerActiveCards = gameboard.playerActiveCards;
        playerActiveCards.add(attackCard);
        playerActiveCards.add(attackCard2);
        playerActiveCards.add(attackCard3);
        ArrayList<Card> playerActiveCardsCopy = (ArrayList<Card>) playerActiveCards.clone();

        ArrayList<Card> computerActiveCards = gameboard.computerActiveCards;
        computerActiveCards.add(blockCard);
        computerActiveCards.add(blockCard2);
        computerActiveCards.add(blockCard3);
        ArrayList<Card> computerActiveCardsCopy = (ArrayList<Card>) computerActiveCards.clone();

        assertArrayEquals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertEquals(1,  gameLogic.block(attacker,blocker,attackCard, blockCard, playerActiveCards, computerActiveCards), "blockpoints should be 1");
        assertTrue(gameLogic.greater == attackCard.getPoint() > blockCard.getBlockPointPoint() && blockCard.getPoint() < attackCard.getBlockPointPoint(), "attackpoints are greater than blockpoints");
        assertFalse(Arrays.equals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray()), "Expected both not to be equal");

        //--------------------

        assertArrayEquals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertEquals(3,  gameLogic.block(attacker,blocker,attackCard2, blockCard2, playerActiveCards, computerActiveCards), "blockpoints should be 3");
        assertTrue(gameLogic.less == attackCard2.getPoint() < blockCard2.getBlockPointPoint() && blockCard2.getPoint() > attackCard2.getBlockPointPoint(), "attackpoints are less than blockpoints");
        assertFalse(Arrays.equals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray()), "Expected both not to be equal");

        //--------------------
        computerActiveCardsCopy.remove(blockCard);
        playerActiveCardsCopy.remove(attackCard2);
        assertArrayEquals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertArrayEquals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertEquals(2,  gameLogic.block(attacker,blocker,attackCard3, blockCard3, playerActiveCards, computerActiveCards), "blockpoints should be 2");
        assertFalse(Arrays.equals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray()), "Expected both not to be equal");
        assertFalse(Arrays.equals(playerActiveCards.toArray(), playerActiveCardsCopy.toArray()), "Expected both not to be equal");
    }




    @Test //test checked /snehal
    public void testManageSelectedCard() {
        Player player = new Player();
        System.out.println("== Test to check logic of manageSelectedCard(), it deletes played cards from hand ==");
        System.out.println("== Test to check logic of manageSelectedCard(), if card is \"fighter\" then playerActiveCardSize will increase by 1 ==");

        Card card1 = new Card("Action", "action1", 3, 3);
        Card card2 = new Card("Fighter", "fighter1", 3, 3);
        Card card3 = new Card("Fighter", "fighter2", 5, 5);


        int beforePlayerActiveCardSize = gameboard.getPlayerActiveCards().size();
        System.out.println("before " + beforePlayerActiveCardSize);
        String action1 = gameLogic.manageSelectedCard(card1, player, gameboard);
        String fighter1 = gameLogic.manageSelectedCard(card2, player, gameboard);
        String fighter2 = gameLogic.manageSelectedCard(card3,player,gameboard);

        Card playedCard = player.getHand().getCardsInHand().get(0);

        gameLogic.manageSelectedCard(playedCard, player, gameboard);

        int afterPlayerActiveCardSize = gameboard.getPlayerActiveCards().size();
        System.out.println("after " + afterPlayerActiveCardSize);


        assertAll(

                () -> assertEquals("Action", action1),
                () -> assertEquals("Fighter", fighter2),
                () -> assertFalse(player.getHand().getCardsInHand().contains(playedCard), "playedCard is not in hand anymore"),
                () -> assertNotEquals(beforePlayerActiveCardSize, afterPlayerActiveCardSize, "size should not be equal")

        );


    }

    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
        CardGenerator.getInstance().setCommonDeck(CardGenerator.getInstance().generateCardsAndGet());

    }



}