
import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Computer;
import com.powerpuff.cardgame.cardGame.Player;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TestGameLogic {


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

        ArrayList<Card> playerActiveCards = new ArrayList<>();
        playerActiveCards.add(attackCard);
        ArrayList<Card> playerActiveCardsCopy = (ArrayList<Card>) playerActiveCards.clone();

        ArrayList<Card> computerActiveCards = new ArrayList<>();
        computerActiveCards.add(blockCard);
        ArrayList<Card> computerActiveCardsCopy = (ArrayList<Card>) computerActiveCards.clone();


        assertTrue(computerActiveCards != null, "should not be null");
        assertArrayEquals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray(), "Expected both to be equal");
        assertTrue(attackCard.getPoint() > blockCard.getBlockPointPoint(), "attack points should be greater than blockpoints");
            computerActiveCards.remove(blockCard);
        assertFalse(Arrays.equals(computerActiveCards.toArray(), computerActiveCardsCopy.toArray()), "Expected both not to be equal");



    }





}
