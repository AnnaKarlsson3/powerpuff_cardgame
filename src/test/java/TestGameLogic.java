
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



    }

    

}
