import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.CardGenerator;
import com.powerpuff.cardgame.cardGame.Hand;

import static org.junit.jupiter.api.Assertions.*;

import com.powerpuff.cardgame.cardGame.PlayerDeck;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestHand {

    Hand testHand;
    ArrayList<Card> cardsInHand;

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach TestHand");
        testHand = new Hand();
        cardsInHand = testHand.getCardsInHand();
    }

    @Test
    public void testCardsInHand() {
        System.out.println("=== Executed test for cards in hand executed ===");

        assertEquals(5, cardsInHand.size());
    }

    @Test //test checked /snehal
    public void testAddNewCardToHand(){
        System.out.println("=== Executed test for adding a card to the hand ===");

        if(testHand.getPlayerDeck().getPlayerCards().isEmpty()){
            assertFalse(testHand.addNewCardToHand());

        }else{
            int sizeBeforeRemove = testHand.getPlayerDeck().getPlayerCards().size();
            assertTrue(testHand.addNewCardToHand());
            System.out.println("=== Executed test for removeCardsInHandFromDeck() which we call inside addNewCardToHand() ===");
            ArrayList<Card> cardsAfterRemovedOne = testHand.getPlayerDeck().getPlayerCards();
            assertFalse(sizeBeforeRemove == cardsAfterRemovedOne.size(),"test for removing that card(which added into hand) from deck");
        }
    }

    @Test
    public void testRemoveCardsInHandFromDeck(){
        System.out.println("=== Executed test for removing cards in hand from deck ===");
        ArrayList<Card> deck = testHand.getPlayerDeck().getPlayerCards();

        assertFalse(deck.containsAll(cardsInHand));
    }

    @Test
    public void testDeletePlayedCard(){
        Card card = new Card("type","card1",7, 5);
        if(cardsInHand.contains(card)){
            assertTrue(testHand.deletePlayedCard(card),"Expected to to be true");
        }else{
            assertFalse(testHand.deletePlayedCard(card),"Expected to be false");
        }



    }

    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
        CardGenerator.getInstance().setCommonDeck(CardGenerator.getInstance().generateCardsAndGet());

    }
}
