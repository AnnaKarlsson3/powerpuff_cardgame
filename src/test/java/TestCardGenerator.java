import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.CardGenerator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestCardGenerator {
    CardGenerator cardGenerator;


    @BeforeEach
    void init(){
        System.out.println("@BeforeEach TestCardGenerator");
        cardGenerator = CardGenerator.getInstance();
    }

    @Test // test checked again /snehal
    void testGenerateCards() {

        assertNotNull(cardGenerator.generateCardsAndGet());
        Assertions.assertEquals( 100 ,cardGenerator.generateCardsAndGet().size() );

    }

    @Test
    public void testShuffleMethod(){
        cardGenerator.generateCardsAndGet();
        cardGenerator.shuffledCards =  (ArrayList<Card>) cardGenerator.getCommonDeck().clone();
        assertArrayEquals(cardGenerator.getCommonDeck().toArray(), cardGenerator.shuffledCards.toArray(), "Expected both to be equal");

        cardGenerator.shuffleCards(cardGenerator.getCommonDeck());

        assertFalse(Arrays.equals(cardGenerator.getCommonDeck().toArray(), cardGenerator.shuffledCards.toArray()), "Expected both not to be equal");

    }


    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
        CardGenerator.getInstance().setCommonDeck(CardGenerator.getInstance().generateCardsAndGet());

    }



}
