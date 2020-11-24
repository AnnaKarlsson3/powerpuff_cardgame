package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    Action action;
    Display display;
    public boolean gameOver = false;
    public Player player;
    public Computer computer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> computerHand;
    public Gameboard gameboard;
    public GameLogic gameLogic;
    private int round = 0;

    //public Card selectedCardFromBoard = null;


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
            System.out.println("Player is starting first");
        } else {
            System.out.println("Computer is starting first");
        }


        while (!gameOver) {
            round++;



            System.out.println(Display.CYAN_BOLD + "------------------| Round - " + round + " |--------------------------------------------------------------\n" + Display.RESET);
            if (random_nr == 1) {

                playerTurn();
                gameOver();

                if (gameOver) break;
                display.printEndMessage();

                action.inputMenu(this);

                computerTurn();
                gameOver();
                if (gameOver) break;

            } else {

                computerTurn();
                gameOver();

                if (gameOver) break;
                display.printEndMessage();

                action.inputMenu(this);


                playerTurn();
                gameOver();
                if (gameOver) break;

            }



        }
        playAgain();

    }


    private void playAgain() {
        display.printPlayAgain();
        action.checkInput(this);


    }

    public void setPlayerName() {
        display.printEnterNameMessage();
        action.inputPlayerName();
        player.setName(action.playerName);
    }


    public void playerTurn() {

        display.printPlayerName(player.getName());
        display.printCardsInHand(player.getHand().getCardsInHand());
        //display.addNumbersToCards(player.getHand().getCardsInHand());

        Card selectedCardFromHand = action.selectCard(player.getHand());

        System.out.println(" ");
        System.out.println("Played card:");
        display.printPlayedCard(selectedCardFromHand);
        System.out.println(" ");
        gameLogic.manageSelectedCard(selectedCardFromHand, player, gameboard);
        if (round > 1) {
            if (gameboard.playerActiveCards.size() > 0) {

                display.printAttackMessage();

                display.printPlayersCardsOnBoard(gameboard.playerActiveCards);

                Card selectedCardFromBoard = action.selectCardFromBoard(gameboard);

                //computer blocking
                Card computerBlockingCard = computer.blockCard(selectedCardFromBoard, gameboard);
                if (computerBlockingCard != null) {
                    System.out.println("Computer blocked your attack with: ");
                    display.printPlayedCard(computerBlockingCard);
                }

                //-Computer choosing one card to block with/if its not null
                if (gameboard.computerActiveCards.size() == 0) {
                    computer.setHp(computer.getHp() - selectedCardFromBoard.getPoint());
                } else {
                    gameLogic.attack(computer, selectedCardFromBoard, computerBlockingCard, gameboard.playerActiveCards, gameboard.computerActiveCards);
                }

            } else display.printAttackMessageNoCardsAvailable();

        }

        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());
        display.printBreakLine();
        System.out.println(" ");

    }

    public void computerTurn() {

        display.printBreakLine();
        display.printComputerTurn();
        computer.computerSendToBoard(gameboard);

        if (gameboard.getComputerActiveCards().isEmpty() && computer.getHand().getCardsInHand().isEmpty()) {
            endGame();
        }
        if (round > 1) {
            if (gameboard.computerActiveCards.size() > 0) {
                Card attackCard = computer.attackCard(gameboard);
                System.out.println("\ncomputer's attack card");
                //System.out.println(attackCard);
                display.printBreakLine();

                if (gameboard.playerActiveCards.size() == 0) {
                    player.setHp(player.getHp() - attackCard.getPoint());
                    display.printBlockMessageNoBlockCardsAvailable();
                } else {
                    display.printBlockMessage();
                    display.printPlayersCardsOnBoard(gameboard.playerActiveCards);
                    Card selectedCardFromBoard = action.selectCardFromBoard(gameboard);
                    gameLogic.attack(player, attackCard, selectedCardFromBoard, gameboard.computerActiveCards, gameboard.playerActiveCards);
                }
                System.out.println(" ");
                display.printPlayedCard(attackCard);
                computer.getHand().deletePlayedCard(attackCard);
            } else
                display.printNoAttackCardsComputer();


        }

        System.out.println(" ");
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());

        //computer.getHand().addNewCardToHand();

        display.printBreakLine();
        System.out.println(" ");

    }

    public boolean gameOver() {

        if(playerHand.isEmpty() && gameboard.getPlayerActiveCards().isEmpty() && computerHand.isEmpty() && gameboard.getComputerActiveCards().isEmpty()){
            if (player.getHp() < computer.getHp()) {
                display.printWinner(computer);
            }
            if (player.getHp() == computer.getHp()) {
                display.printTie();
            }
            if (computer.getHp() < player.getHp()) {
                display.printWinner(player);
            }

            gameOver = true;

        }

        if( player.getHp() < 0 || (playerHand.isEmpty() && gameboard.getPlayerActiveCards().isEmpty())) {
            display.printWinner(computer);
            gameOver = true;
        }

        if( computer.getHp() < 0 || (computerHand.isEmpty() && gameboard.getComputerActiveCards().isEmpty())) {
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

    void reStart() {
        Game game = new Game();
        game.run();
    }


}
