
import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Computer;
import com.powerpuff.cardgame.cardGame.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestGameLogic {


    @Test
    public void testAttack() {
        Computer computer = new Computer();
        Card attackCard = new Card("Fighter", "Piner", 3, 3);
        Card blockCard = new Card("Fighter", "Dora", 1,1);

        int damage = attackCard.getPoint() - blockCard.getBlockPointPoint();
        assertEquals(2, attackCard.getPoint() - blockCard.getBlockPointPoint(), "answer should be 2");
        assertTrue(damage > blockCard.getBlockPointPoint(), "damage is greater than blockpoints");
            computer.setHp(damage);

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



}
