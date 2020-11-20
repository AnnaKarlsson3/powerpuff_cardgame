import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Computer;
import com.powerpuff.cardgame.cardGame.Game;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestComputer {
    Computer computer;
    Game game;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        game = new Game();
        computer = new Computer();

    }

    @Test
    void testPlayCardTrue(){
        ArrayList<Card> cardsInHand = computer.getHand().cardsInHand;

        if(cardsInHand.isEmpty()){
            assertNull(computer.playCard());
        } else {
            assertNotNull(computer.playCard());
        }
    }

    @Test
    void testAttackCard(){
        Card computerCard = new Card("Fighter", "MockCard 2", 3 ,3);
        ArrayList<Card> computersCards = game.gameboard.getComputerActiveCards();
        computersCards.add(computerCard);
        if(!computersCards.isEmpty()){
            assertNotNull(computer.attackCard(game.gameboard));
        } else {
            assertNull(computer.attackCard(game.gameboard));
        }
    }

    @Test
    void testblockCard(){
        Card computerCard = new Card("Fighter", "MockCard 2", 3 ,3);
        ArrayList<Card> computersCards = game.gameboard.getComputerActiveCards();
        computersCards.add(computerCard);
        Card playersCard = new Card("Fighter", "MockCard 1", 3 ,3);
        if(!computersCards.isEmpty()){
            assertNotNull(computer.blockCard(playersCard, game.gameboard));
        } else {
            assertNull(computer.blockCard(playersCard, game.gameboard));
        }
    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }
}
