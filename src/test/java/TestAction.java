
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




    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }


}