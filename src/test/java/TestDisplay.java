import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestDisplay {

    Display display;

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach executed");
        display = new Display();
    }

    @Test
    public void testEnterNameMessage() {
        String actual = display.enterNameMessage;
        String expected = "Enter player name:";

        assertEquals(expected, actual);
    }

    @Test
    public void testPlayerName() {
        display.playerNameTurn();

        String actual = display.playerNameTurn;
        String expected = " it´s your turn!";

        assertEquals(expected, actual);
    }


    @Test
    public void testPrintComputerTurnMessage() {
        display.printComputerTurn();

        String actual = display.computerTurn;
        String expected = "computer´s turn!";

        assertEquals(expected, actual);
    }


    @Test
    public void testPrintPlayerHpMessage() {
        display.printPlayerHpMessage();
        String actual = display.playerHp;
        String expected = "Player HP is: ";

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintComputerHpMessage() {
        display.printComputerHpMessage();
        String actual = display.computerHp;
        String expected = "Computer HP is: ";

        assertEquals(expected, actual);
    }


    @Test
    public void testNumerationOfCardsInHand() {
        Hand hand = new Hand();

        List<String> numberedCards = display.addNumbersToCards(hand.getCardsInHand());

        List<String> cardNumbers = numberedCards
                .stream()
                .map(card -> card.substring(0, 1))
                .collect(Collectors.toList());

        List<String> listOfNumbers = Stream.of("1", "2", "3", "4", "5")
                .collect(Collectors.toList());

        assertEquals(listOfNumbers, cardNumbers);
    }

    @Test
    public void testDisplayPlayedCard() {
        Hand hand = new Hand();
        Card card = (Card) hand.getCardsInHand().get(0);

        display.printPlayedCard(card);

        String expected = "Played card - Type: " + card.getType() + " - Name: " + card.getName() + " - Points: " + card.getPoint();
        String actual = display.playedCard;

        assertEquals(expected, actual);
    }


    @Test
    public void testDisplayBlockMessage(){
        String actual = display.blockMessage();
        String expected = "Choose which card you want to block with";

        assertEquals(expected, actual);
        assertNotNull(display.blockMessage(), "should not be empty");
    }

    @Test
    public void testDisplayBlockMessageNoCardsAvailible(){
        String actual = display.blockMessageNoBlockCardsAvailable();
        String expected = "No block cards left";
        assertEquals(expected, actual);
        assertNotNull(display.blockMessageNoBlockCardsAvailable());
    }

    @Test
    public void testDisplayActionMessage() {
        String actual = display.attackMessage();
        String expected = "Choose attack card";
        assertEquals(actual, expected);
        assertNotNull(display.attackMessage());
    }

    @Test
    public void testDisplayBlockMessageNoCardsAvailable(){
        String actual = display.attackMessageNoCardsAvailable();
        String expected = "No attack cards left";
        assertEquals(expected, actual);
        assertNotNull(display.attackMessageNoCardsAvailable());
    }




    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
    }
}
