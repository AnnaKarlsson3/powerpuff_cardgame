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


    }



    public void run() {

        int random_nr = (int)Math.round(Math.random());

        setPlayerName();

        if(random_nr == 1){
            System.out.println("Player is starting first");
        } else {
            System.out.println("Computer is starting first");
        }




        while (!gameOver) {
            round++;
            System.out.println("------------------| Round - " + round +" |------------------------------\n");



            if( random_nr == 1){
                playerTurn();
                display.printEndMessage();
                action.inputMenu(this);
                if (gameOver) break;

                computerTurn();

            } else {
                computerTurn();
                display.printEndMessage();
                action.inputMenu(this);
                if (gameOver) break;

                playerTurn();

            }



            gameOver();


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
        display.addNumbersToCards(player.getHand().getCardsInHand());

        Card selectedCardFromHand = action.selectCard(player.getHand());

        System.out.println(" ");
        display.formatCardToPlay(selectedCardFromHand);
        System.out.println(" ");
        gameLogic.manageSelectedCard(selectedCardFromHand, player, gameboard);
        if (round > 1) {
            if (gameboard.playerActiveCards.size() > 0) {

                display.printAttackMessage();

                display.printPlayersCardsOnBoard(gameboard.playerActiveCards);

                Card selectedCardFromBoard = action.selectCardFromBoard(gameboard);

                //computer blocking
                Card computerBlockingCard = computer.blockCard(selectedCardFromBoard, gameboard);
                System.out.println("computer blocking card: " + computerBlockingCard);

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
        System.out.println("---------------------");
        System.out.println(" ");
    }

    public void computerTurn() {
        System.out.println("---------------------");
        display.printComputerTurn();
        computer.computerSendToBoard(gameboard);

        if (gameboard.getComputerActiveCards().isEmpty() && computer.getHand().getCardsInHand().isEmpty()) {
            endGame();
        }
        if (round > 1) {
            if (gameboard.computerActiveCards.size() > 0) {
                Card attackCard = computer.attackCard(gameboard);
                System.out.println("\ncomputer's attack card");
                System.out.println(attackCard);
                System.out.println("----------------------------------------------------");

                if (gameboard.playerActiveCards.size() == 0) {
                    player.setHp(player.getHp() - attackCard.getPoint());
                    System.out.println("Player has no blockCard!");
                } else {
                    display.printBlockMessage();
                    display.printPlayersCardsOnBoard(gameboard.playerActiveCards);
                    Card selectedCardFromBoard = action.selectCardFromBoard(gameboard);
                    gameLogic.attack(player, attackCard, selectedCardFromBoard, gameboard.computerActiveCards, gameboard.playerActiveCards);
                }
                System.out.println(" ");
                display.formatCardToPlay(attackCard);
                computer.getHand().deletePlayedCard(attackCard);
            } else System.out.println("computer not having any Cards on board to attack with");


        }

        System.out.println(" ");
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());

        //computer.getHand().addNewCardToHand();

        System.out.println("---------------------");
        System.out.println(" ");
    }

    public boolean gameOver() {
        playerHand = player.getHand().getCardsInHand();
        computerHand = computer.getHand().getCardsInHand();

        if (player.getHp() <= 0 || playerHand.size() == 0) {
            if (player.getHp() < computer.getHp()) {
                display.printWinner(computer);
            }
            if (player.getHp() == computer.getHp()) {
                display.printTie();
            }
            gameOver = true;
        }
        if (computer.getHp() <= 0 || computerHand.size() == 0) {
            if (computer.getHp() < player.getHp()) {
                display.printWinner(player);
            }
            if (computer.getHp() == player.getHp()) {
                display.printTie();
            }

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
