package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Game {
    public Action action;
    Display display;
    public boolean gameOver = false;
    public Player player;
    public Computer computer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> computerHand;
    public Gameboard gameboard;
    public GameLogic gameLogic;
    public int round = 0;


    public Game() {
        player = new Player();
        computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        display = new Display();
        action = new Action();
        gameboard = new Gameboard();
        gameLogic = new GameLogic();
        playerHand = player.getHand().getCardsInHand();
        computerHand = computer.getHand().getCardsInHand();

    }


    public void run() {

        int random_nr = (int) Math.round(Math.random());

        display.printRules();
        setPlayerName();

        if (random_nr == 1) {
            System.out.println("You are going first");
        } else {
            System.out.println("Computer is going first");
        }


        while (!gameOver) {
            round++;

            System.out.println(Display.CYAN_BOLD + "------------------| Round - " + round + " |--------------------------------------------------------------\n" + Display.RESET);
            sleep(1000);
            if (random_nr == 1) {
                playerTurn();
                gameOver();
                if (gameOver) break;
                display.printBreakLine();
                computerTurn();
                gameOver();
                display.printEndMessage();
                action.inputMenu(this);
            } else {
                computerTurn();
                gameOver();
                display.printBreakLine();
                if (gameOver) break;
                playerTurn();
                gameOver();
                display.printEndMessage();
                action.inputMenu(this);
            }
        }
        playAgain();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    private void playAgain() {
        display.printPlayAgain();
        action.checkInput(this);
    }

    private void setPlayerName() {
        display.printEnterNameMessage();
        action.inputPlayerName();
        player.setName(action.playerName);
    }

    public void playerTurn() {

        display.printPlayerName(player.getName());
        sleep(1000);
        display.printCardsInHand(player.getHand().getCardsInHand());
        Card selectedCardFromHand = action.selectCard(player.getHand());
        sleep(1000);
        display.printPlayerPlayedCard(selectedCardFromHand);
        gameLogic.manageSelectedCard(selectedCardFromHand, player, gameboard);
        playerAttac();

        System.out.println("\n");
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());
        System.out.println("\n");
    }

    public boolean playerAttac(){
        boolean attackAndOrBlockHappening = false;
        if (round > 1) {
            if (gameboard.playerActiveCards.size() > 0) {

                display.printComputersCardsOnBoard(gameboard.computerActiveCards);
                display.printAttackMessage();
                display.printPlayersCardsOnBoard(gameboard.playerActiveCards);
                display.printEnterNumber();

                //sleep(2000);

                Card selectedCardFromBoard = action.selectCardFromBoard(gameboard);
                //-Computer choosing one card to block with/if its not null
                if (gameboard.computerActiveCards.size() == 0) {
                    System.out.println("Computer doesn't have card to block");
                    computer.setHp(computer.getHp() - selectedCardFromBoard.getPoint());
                } else {
                    //computer blocking
                    Card computerBlockingCard = computer.blockCard(selectedCardFromBoard, gameboard);
                    //sleep(2000);
                    System.out.println("Computer blocked your attack with: ");
                    display.printComputerPlayedCard(computerBlockingCard);
                    gameLogic.attack(computer, player, selectedCardFromBoard, computerBlockingCard, gameboard.playerActiveCards, gameboard.computerActiveCards);
                }

            } else display.printAttackMessageNoCardsAvailable();
        }

        return attackAndOrBlockHappening;
    }

    public void computerTurn() {
        display.printComputerTurn();
        sleep(1000);
        computer.computerSendToBoard(gameboard);
        sleep(2000);
        computerAttackAndOrBlock();
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());
    }

    public boolean computerAttackAndOrBlock() {

        boolean attackAndOrBlockHappening = false;

        if (round > 1) {
            if (gameboard.computerActiveCards.size() > 0) {
                display.printComputersCardsOnBoard(gameboard.computerActiveCards);
                sleep(2000);
                Card attackCard = computer.attackCard(gameboard);
                System.out.println("\nComputer attacked you with " + attackCard.getPoint() + " damage");
                display.printPlayedCard(attackCard, Display.GREEN_BOLD_BRIGHT, Display.CYAN_BOLD);
                sleep(2000);
                display.printBreakLine();

                if (gameboard.playerActiveCards.size() == 0) {
                    player.setHp(player.getHp() - attackCard.getPoint());
                    display.printBlockMessageNoBlockCardsAvailable();

                } else {
                    display.printBlockMessage();
                    display.printPlayersCardsOnBoard(gameboard.playerActiveCards);
                    display.printEnterNumber();
                    sleep(4000);
                    Card playerBlockingCard = action.selectCardFromBoard(gameboard);
                    gameLogic.attack(computer, player, attackCard, playerBlockingCard, gameboard.computerActiveCards, gameboard.playerActiveCards);
                }
                attackAndOrBlockHappening = true;
            } else
                display.printNoAttackCardsComputer();
        }
        return attackAndOrBlockHappening;
    }

    public boolean gameOver() {
        if (playerHand.isEmpty() && gameboard.getPlayerActiveCards().isEmpty() && computerHand.isEmpty() && gameboard.getComputerActiveCards().isEmpty()) {
            if (player.getHp() < computer.getHp()) {
                display.printWinner(computer);
                gameOver = true;
                return gameOver;
            }
            if (player.getHp() == computer.getHp()) {
                display.printTie();
                gameOver = true;
                return gameOver;
            }
            if (computer.getHp() < player.getHp()) {
                display.printWinner(player);
                gameOver = true;
                return gameOver;
            }
        }

        if (player.getHp() <= 0 || (playerHand.isEmpty() && gameboard.getPlayerActiveCards().isEmpty())) {
            display.printWinner(computer);
            gameOver = true;
        }

        if (computer.getHp() <= 0 || (computerHand.isEmpty() && gameboard.getComputerActiveCards().isEmpty())) {
            display.printWinner(player);
            gameOver = true;
        }

        return gameOver;
    }

    void endGame() {
        gameOver = true;
    }

    public void continueGame() {
        gameOver = false;
    }

    public void reStart() {
        Game game = new Game();
        game.run();
    }

}
