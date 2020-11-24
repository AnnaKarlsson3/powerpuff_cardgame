import com.powerpuff.cardgame.cardGame.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestDisplay {

    Display display;
    Player player;
    Computer computer;
    String BOLD = "\u001b[1m";
    String RESET_COLOR = "\u001B[0m";

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach executed");
        display = new Display();
        player = new Player();
        computer = new Computer();
    }

    @Test
    public void testEnterNameMessage() {
        String expected = BOLD + "Enter player name: " + RESET_COLOR;
        assertEquals(expected, display.enterNameMessage(), "strings should be equal");
    }

    @Test
    public void testPlayerNameTurn() {
        player.setName("Anders");
        String expected = BOLD + "It's your turn, " + player.getName() + RESET_COLOR;
        assertEquals(expected, display.playerNameTurn(player.getName()), "Strings should be equal");
    }


    @Test
    public void testPrintComputerTurnMessage() {
       String expected = "It's computer's turn.";
       assertEquals(expected, display.printComputerTurnMessage(), "strings should be equal");
    }


    @Test
    public void testPrintPlayerHpMessage() {
        player.setHp(20);
        String expected = BOLD + "Player HP is: " + player.getHp() + RESET_COLOR;

        assertEquals(expected, display.printPlayerHpMessage(player.getHp()), "strings should be equal");
    }

    @Test
    public void testPrintComputerHpMessage() {
        computer.setHp(20);
        String expected = BOLD + "Computer HP is: " + computer.getHp() + RESET_COLOR;

        assertEquals(expected, display.printComputerHpMessage(computer.getHp()));
    }


//    @Test
//    public void testNumerationOfCardsInHand() {
//        Hand hand = new Hand();
//
//        List<String> numberedCards = display.addNumbersToCards(hand.getCardsInHand());
//
//        List<String> cardNumbers = numberedCards
//                .stream()
//                .map(card -> card.substring(0, 1))
//                .collect(Collectors.toList());
//
//        List<String> listOfNumbers = Stream.of("1", "2", "3", "4", "5")
//                .collect(Collectors.toList());
//
//        assertEquals(listOfNumbers, cardNumbers);
//    }
//
//    @Test
//    public void testDisplayPlayedCard() {
//        Hand hand = new Hand();
//        Card card = (Card) hand.getCardsInHand().get(0);
//
//        display.printPlayedCard(card);
//
//        String expected = "Played card - Type: " + card.getType() + " - Name: " + card.getName() + " - Points: " + card.getPoint();
//        String actual = display.playedCard;
//
//        assertEquals(expected, actual);
//    }

    @Test
    public void testDisplayBlockMessage(){
        String actual = display.blockMessage();
        String expected = "Choose which card you want to block with.";

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
        String expected = "No attack cards left.";
        assertEquals(expected, actual);
        assertNotNull(display.attackMessageNoCardsAvailable());
    }

    @Test
    public void testDisplayComputerNoCardsOnBoard(){
        String actual = display.computerNoCardsOnBoardMessage();
        String expected = "Computer doesn't have any cards on the board.";

        assertNotNull(display.computerNoCardsOnBoardMessage(), "should not be null");
        assertEquals(actual, expected);
    }

    @Test
    public void testComputerPlacedActionCardPrint(){
        String actual = display.computerPlayedActionCard();
        String expected = "Computer played an Action card: ";

        assertNotNull(display.computerPlayedActionCard());
        assertEquals(actual, expected);
    }

    @Test
    public void testComputerPlayedFighterCard(){
        String actual = display.computerPlacedFighterCard();
        String expected = "Computer placed a Fighter card on the Board";

        assertNotNull(display.computerPlacedFighterCard());
        assertEquals(actual, expected);
    }

    @Test
    public void testPrintBreakLine () {
        String actual = display.breakLineMessage();
        String expected = "------------------------";
        assertNotNull(display.breakLineMessage());
        assertEquals(actual, expected);
    }

    @Test
    public void testPrintComputerNoAttackCardsMessage () {
        String actual = display.computerNoAttackCardsMessage();
        String expected = "Computer doesn't have any cards to attack with.";
        assertEquals(actual, expected);
        assertNotNull(display.computerNoAttackCardsMessage());
    }

    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
    }
}
