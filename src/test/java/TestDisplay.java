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

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach executed");
        display = new Display();
        player = new Player();
        computer = new Computer();
    }

    @Test
    public void testEnterNameMessage() {
        String expected = "Enter player name: ";
        assertEquals(expected, display.enterNameMessage(), "strings should be equal");
    }

    @Test
    public void testPrintRulesMessage(){
        String expected = "Rules: \n *Player vs computer \n *You start round 1 randomly \n *Fighter-Cards has an attackPoint and a blockPoint, if you play an fighter-card you have to put it on the board \n " +
                "*Action-Cards has an healthPoint and 0 in blockPoints, if you play an action-card, it gives you life according to the healthPoints \n *You can not attack the first round \n" +
                "*If you have fighters-cards on the board, you have to attack \n *you can only attack with one fighter/round \n *If computer attacks and you have fighters-cards on board, you have to block \n " +
                "*If your block-cards blockPoints is less then computers attackPoints, or you don't have any block-cards, you will take damage \n *The card with less blockPoints than attackPoints will die in an attack/block \n " +
                "*You winn when computers health is 0 or it´s deck is empty \n *You loose when your health is 0 or your deck is empty ";
        assertEquals(expected, display.printRulesMessage(), "Strings should be equal");
    }

    @Test
    public void testPlayerNameTurn() {
        player.setName("Anders");
        String expected = "It´s " + player.getName() + " turn";
        assertEquals(expected, display.playerNameTurn(player.getName()), "Strings should be equal");
    }


    @Test
    public void testPrintComputerTurnMessage() {
       String expected = "It´s computer´s turn";
       assertEquals(expected, display.printComputerTurnMessage(), "strings should be equal");
    }


    @Test
    public void testPrintPlayerHpMessage() {
        player.setHp(20);
        String expected = "Player HP is: " + player.getHp();

        assertEquals(expected, display.printPlayerHpMessage(player.getHp()), "strings should be equal");
    }

    @Test
    public void testPrintComputerHpMessage() {
        computer.setHp(20);
        String expected = "Computer HP is: " + computer.getHp();

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

    @Test
    public void testDisplayComputerNoCardsOnBoard(){
        String actual = display.computerNoCardsOnBoardMessage();
        String expected = "Computer doesn't have any card on board";

        assertNotNull(display.computerNoCardsOnBoardMessage(), "should not be null");
        assertEquals(actual, expected);
    }

    @Test
    public void testComputerPlacedActionCardPrint(){
        String actual = display.computerPlayedActionCard();
        String expected = "Computer Played Action Card: ";

        assertNotNull(display.computerPlayedActionCard());
        assertEquals(actual, expected);
    }

    @Test
    public void testComputerPlayedFighterCard(){
        String actual = display.computerPlacedFighterCard();
        String expected = "Computer placed a Fighter Card on the Board";
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
    public void testPrintComputerNoAttachCardsMessage () {
        String actual = display.computerNoAttackCardsMessage();
        String expected = "computer is not having any cards on the board to attack with";
        assertEquals(actual, expected);
        assertNotNull(display.computerNoAttackCardsMessage());
    }


    @AfterEach
    void cleanUp() {
        System.out.println("@AfterEach executed");
    }
}
