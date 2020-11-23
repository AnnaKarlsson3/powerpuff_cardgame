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

    public Game() {
        player = new Player();
        computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        display = new Display();
        action = new Action();
        playerHand = player.getHand().getCardsInHand();
        computerHand = computer.getHand().getCardsInHand();
        gameboard = new Gameboard();
        gameLogic = new GameLogic();


    }


    public void run() {

        int random_nr = (int) Math.round(Math.random());

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
                //gameOver(playerHand, player.getHp(), computerHand, computer.getHp());

                display.printEndMessage();
                action.inputMenu(this);
                if (gameOver) break;

                computerTurn();
                //gameOver(playerHand, player.getHp(), computerHand, computer.getHp());


            } else {
                computerTurn();
                //gameOver(playerHand, player.getHp(), computerHand, computer.getHp());

                display.printEndMessage();
                action.inputMenu(this);
                if (gameOver) break;

                playerTurn();
                //gameOver(playerHand, player.getHp(), computerHand, computer.getHp());

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
        gameOver(playerHand, player.getHp(), computerHand, computer.getHp());

    }

    public void computerTurn() {
        display.printBreakLine();
        display.printComputerTurn();
        computer.computerSendToBoard(gameboard);

        if (round > 1) {
            if (gameboard.computerActiveCards.size() > 0) {
                Card attackCard = computer.attackCard(gameboard);
                System.out.println("\ncomputer's attack card");
                display.printPlayedCard(attackCard);
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
            } else
                display.printNoAttackCardsComputer();

        }

        System.out.println(" ");
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());
        display.printBreakLine();
        System.out.println(" ");
        gameOver(playerHand, player.getHp(), computerHand, computer.getHp());

    }

    public boolean gameOver(ArrayList<Card> playerHand, int playerHp, ArrayList<Card> computerHand, int computerHp) {

        if (playerHand.isEmpty() && computerHand.isEmpty() && gameboard.getPlayerActiveCards().isEmpty() && gameboard.getComputerActiveCards().isEmpty()) {
            if (playerHp == computerHp) {
                display.printTie();
            }
            if (playerHp < computerHp) {
                display.printWinner(computer);
            }
            if (computerHp < playerHp) {
                display.printWinner(player);
            }
            gameOver = true;
        }

        if (playerHp <= 0 || (playerHand.isEmpty() && gameboard.getPlayerActiveCards().isEmpty())) {
            display.printWinner(computer);
            gameOver = true;
        }
        if (computerHp <= 0 || (computerHand.isEmpty() && gameboard.getComputerActiveCards().isEmpty())) {
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
