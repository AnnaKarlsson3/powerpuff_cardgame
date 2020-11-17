package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Action action;
    Display display;
    public boolean gameOver = false;
    public Player player;
    public Computer computer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> computerHand;


    public Game(){
        player = new Player();
        computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        display = new Display();
        action = new Action();
    }

    public void run() {

        setPlayerName();

        while (!gameOver){

            playerTurn();
            display.printEndMessage();
            action.inputMenu(this);
            if (gameOver) break;

            computerTurn();
            gameOver();

        }

    }

    public void setPlayerName(){
        display.printEnterNameMessage();
        action.inputPlayerName();
        player.setName(action.playerName);
    }

    public void playerTurn(){
        System.out.println("---------------------");
        display.printPlayerName(player.getName());
        display.printCardsInHand(player.getHand().getCardsInHand());
        display.addNumberCardsInHand(player.getHand().getCardsInHand());


        Card card = action.selectCard(player.getHand());

        System.out.println(" ");
        display.formatCardToPlay(card);
        System.out.println(" ");

        updateHpIfPlayersTurn(card);

        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());

        player.getHand().deletePlayedCard(card);

        player.getHand().addNewCardToHand();

        System.out.println("---------------------");
        System.out.println(" ");
    }

    public void computerTurn(){
        System.out.println("---------------------");
        display.printComputerTurn();

        Card playedCard = computer.playCard();
        if(playedCard == null){
            endGame();
        }

        System.out.println(" ");
        display.formatCardToPlay(playedCard);

        updateHpIfComputersTurn(playedCard);

        System.out.println(" ");
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());

        computer.getHand().deletePlayedCard(playedCard);

        computer.getHand().addNewCardToHand();

        System.out.println("---------------------");
        System.out.println(" ");
    }

    public boolean gameOver() {
        playerHand = player.getHand().getCardsInHand();
        computerHand = computer.getHand().getCardsInHand();

        if (player.getHp() <= 0 || playerHand.size() == 0) {
            if(player.getHp() < computer.getHp()){
                display.printWinner(computer);
            }
            if(player.getHp() == computer.getHp()){
                display.printTie();
            }
            gameOver = true;
        }
        if (computer.getHp() <= 0 || computerHand.size() == 0) {
            if(computer.getHp() < player.getHp()){
                display.printWinner(player);
            }
            if(computer.getHp() == player.getHp()){
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

    public int updateHpIfPlayersTurn(Card playedCard) {
        int playerHp = player.getHp();
        if (playedCard.getType().equals("Action")) {
            playerHp = playerHp + playedCard.getPoint();
            player.setHp(playerHp);
        } else {
            computer.setHp(computer.getHp() - playedCard.getPoint());
        }
        return playerHp;
    }

    public int updateHpIfComputersTurn(Card playedCard) {
        int computerHp = computer.getHp();
        if (playedCard.getType().equals("Action")) {
            computerHp = computerHp + playedCard.getPoint();
            computer.setHp(computerHp);
        } else {
            player.setHp(player.getHp() - playedCard.getPoint());
        }
        return computerHp;
    }
}
