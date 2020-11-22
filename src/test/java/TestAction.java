
import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAction {

    Action action;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        action = new Action();
    }

    @Test
    public void testInputPlayerName(){

        assertNotNull(action.playerName, "The name should not be null" );
    }



    @Test
    public void testChooseOneCard(){
        Hand hand = new Hand();
        Action action = new Action();
        int numberInHand = 3;

        Card card1 = hand.cardsInHand.get(numberInHand-1);
        Card card2 = action.findCardByNumber(numberInHand, hand);

        assertEquals(card1, card2 );
        assertNotNull(card1);
        assertNotNull(card2);

        assertNotNull(action.findCardByNumber(numberInHand, hand));
        assertFalse(card1.toString().length() == 0);


    }

    @Test
    public void testSelectCardFromGameBoard(){
        Game game = new Game();
        Gameboard gameboard = new Gameboard();
        int selectedCardOnBoard = 1;

        Card activeCard1 = new Card("Fighter", "MockCard 1", 3 ,3);
        Card activeCard2 = new Card("Fighter", "MockCard 2", 3 ,3);

        ArrayList<Card> playerActiveCards = game.gameboard.getPlayerActiveCards();
        playerActiveCards.add(activeCard1);
        playerActiveCards.add(activeCard2);
        Card card1 = game.gameboard.getPlayerActiveCards().get(selectedCardOnBoard-1);


       assertEquals(card1,activeCard1 );

       Card placedCard = gameboard.placePlayerCardOnGameboard(new Card("Fighter", "Mockcard 3", 3, 3));
       Card card2 = action.findCardByNumberFromBoard(selectedCardOnBoard, gameboard);

       assertEquals(placedCard, card2);

    }




    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }


}