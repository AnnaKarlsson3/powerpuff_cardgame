import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Game;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestGame {
    Game game;

    @BeforeEach
    public void init() {
        game = new Game();

    }

    @Test
    public void testStartGame() {
        assertTrue(!game.gameOver);
    }


   /* @Test
    public void testPlayerAttackIf(){
        game.round = 2;
        new Card("Fighter", "Piner", 3, 3);
        game.gameLogic.manageSelectedCard(new Card("Fighter", "Piner", 3, 3), game.player, game.gameboard);

        if(game.round > 1 && game.gameboard.playerActiveCards.size() > 0){
            assertTrue(game.playerAttac());
        }else{
            assertFalse(game.playerAttac());
        }
    }*/

  /*  @Test
    public void testPlayerAttackElse(){
        game.round = 1;
        game.gameboard.playerActiveCards.clear();

        if(game.round > 1 && game.gameboard.playerActiveCards.size() > 0){
            assertTrue(game.playerAttac());
        }else{
            assertFalse(game.playerAttac());
        }
    }*/

    @Test
    public void testGameOverIsTie() {
        game.player.setName("MockPlayer");
        game.playerHand.clear();
        game.computerHand.clear();
        game.gameboard.getPlayerActiveCards().clear();
        game.gameboard.getComputerActiveCards().clear();
        game.player.setHp(0);
        game.computer.setHp(0);

        System.out.println("Test for Tie");
        if(game.playerHand.isEmpty() && game.gameboard.getPlayerActiveCards().isEmpty() && game.computerHand.isEmpty() && game.gameboard.getComputerActiveCards().isEmpty()){
            assertTrue(game.gameOver());
        } else {
            assertFalse(game.gameOver());
        }

    }

    @Test
    public void testGameOverComputerWin() {
        game.player.setName("MockPlayer");
        game.playerHand.clear();
        game.computerHand.clear();
        game.gameboard.getPlayerActiveCards().clear();
        game.gameboard.getComputerActiveCards().clear();
        game.player.setHp(0);
        game.computer.setHp(1);

        System.out.println("Test for Computer Win");
        if(game.playerHand.isEmpty() && game.gameboard.getPlayerActiveCards().isEmpty() && game.computerHand.isEmpty() && game.gameboard.getComputerActiveCards().isEmpty()){
            assertTrue(game.gameOver());
        } else {
            assertFalse(game.gameOver());
        }
    }

    @Test
    public void testGameOverPlayerWin() {
        game.player.setName("MockPlayer");
        game.playerHand.clear();
        game.computerHand.clear();
        game.gameboard.getPlayerActiveCards().clear();
        game.gameboard.getComputerActiveCards().clear();
        game.player.setHp(1);
        game.computer.setHp(0);

        System.out.println("Test for Player Win");
        if(game.playerHand.isEmpty() && game.gameboard.getPlayerActiveCards().isEmpty() && game.computerHand.isEmpty() && game.gameboard.getComputerActiveCards().isEmpty()){
            assertTrue(game.gameOver());
        } else {
            assertFalse(game.gameOver());
        }
    }

    @Test
    public void testGameOverJustTheComputerWin(){

        System.out.println("Game Over when player's hp is less or equal to 0");
        game.player.setHp(0);
        assertTrue(game.gameOver());

        System.out.println("\n" + "----------------------------------------");
        System.out.println("Game Over when playerhand and board is empty");
        game.player.setHp(5);
        game.playerHand.clear();
        game.gameboard.getPlayerActiveCards().clear();

        if( game.player.getHp() <= 0 || (game.playerHand.isEmpty() && game.gameboard.getPlayerActiveCards().isEmpty())) {
        assertTrue(game.gameOver());
        } else {
            assertFalse(game.gameOver());
        }
    }

    @Test
    public void testGameOverJustThePlayerWin(){
        game.player.setName("MockPlayer");
        System.out.println("Game Over when computer's hp is less or equal to 0");
        game.computer.setHp(0);
        assertTrue(game.gameOver());

        System.out.println("\n" + "----------------------------------------");
        System.out.println("Game Over when computerhand and board is empty");
        game.computer.setHp(5);
        game.computerHand.clear();
        game.gameboard.getComputerActiveCards().clear();

        if( game.computer.getHp() <= 0 || (game.computerHand.isEmpty() && game.gameboard.getComputerActiveCards().isEmpty())) {
        assertTrue(game.gameOver()); }
        else {
            assertFalse(game.gameOver());
        }
    }


    @Test
    public void testComputerAttackFirstRound(){
        game.round = 1;

        if(game.round == 1) {
            System.out.println("Computer's attack false");
            assertFalse(game.computerAttackAndOrBlock());
        }

        game.round = 2;
        Card computerCard = new Card("Fighter", "MockCard 2", 3 ,3);
        game.gameboard.computerActiveCards.add(computerCard);
        if(game.round > 1 && !game.gameboard.computerActiveCards.isEmpty()) {
            System.out.println("Computer's attack true");
            assertTrue(game.computerAttackAndOrBlock());
        }

    }


    @Test
    public void testCreateNewGame(){
        try {
            new Game();
        } catch (Exception ex) {
            fail();
        }
        Game game = new Game();
        assertFalse(game.gameOver);



    }

}
