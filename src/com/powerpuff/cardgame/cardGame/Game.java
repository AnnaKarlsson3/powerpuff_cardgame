package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Game {
    Action action = new Action();
    Display display;
    public boolean gameOver = false;
    public Player player;
    public Computer computer;
    public ArrayList<Card> playerDeck;
    public ArrayList<Card> computerDeck;


    public int counter;


    public Game(){
        player = new Player();
        computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        display = new Display();
        System.out.println(player.getHand().getCardsInHand().size());
        System.out.println(player.getHand().getPlayerDeck().getPlayerCards().size());


    }

    public void run() {

        //startGame/menu

        display.printEnterNameMessage();
        action.inputPlayerName();
        player.setName(action.playerName);


        //get cards for the player
        player.getHand().getPlayerDeck().getCardsFromGeneratedCards();


        randomStart();

        //game
        while (!gameOver){

            gameTurn();

            gameOver();
        }

        //print hwo won

    }

    public void playerTurn(){

        //print playername turn
        display.printPlayerName(player.getName());

        //print your cards in hand
        display.printCardsInHand(player.getHand().getCardsInHand());

        //input card choice
        //execute playedcard in playerclass/computerclass
        //execute delete onCard from hand
        //print witch card played
        //execute opponent playerHp - cardDamage
        //print opponent playerHp status
        //print playerHp status
        //execute drawOnCard from deck
        //execute delete oneCard from deck
        display.printPlayerHp(player.getHp());


        //put in menu? print continue?
       // display.printEndMessage();
        //action.inputMenu();
        //endGame();
    }

    public void computerTurn(){
        display.printComputerTurn();

        System.out.println("computer Hp: " + computer.getHp());
    }

    public void gameTurn(){
        if(counter == 0)
        {
            playerTurn();
            computerTurn();
        }
        if(counter == 1)
        {
            computerTurn();
            playerTurn();
        }
    }

    public int randomStart(){
        return counter = (int) (Math.random()*2);
    }


    public boolean gameOver() {

        playerDeck = player.getHand().getPlayerDeck().getPlayerCards();
        computerDeck = computer.getHand().getPlayerDeck().getPlayerCards();

        if (player.getHp() == 0 || playerDeck.size() == 0) {
            gameOver = true;
        }
        if (computer.getHp() == 0 || computerDeck.size() == 0) {
            gameOver = true;
        }
        return gameOver;
    }

    void endGame() {
        gameOver = true;
    }

    public int updateHpOfPlayer(Card playedCard) {
        int playerHp = player.getHp();
        if (playedCard.getType().equals("Action")) {
            playerHp = playerHp + playedCard.getPoint();
            player.setHp(playerHp);
        } else {
            computer.setHp(computer.getHp() - playedCard.getPoint());
        }
        return playerHp;
    }

    public int updateHpOfComputer(Card playedCard) {
        int computerHp = computer.getHp();
        if (playedCard.getType().equals("Action")) {
            computerHp = computerHp + playedCard.getPoint();
            computer.setHp(computerHp);
        } else {
            player.setHp(player.getHp() - playedCard.getPoint());
        }
        return computerHp;
    }


//    public int updateHp(Player player, Card playersCard, Card opponentsCard) {
//        int hp = player.getHp();
//        if (playersCard.getType().equals("Action")) {
//            hp = hp + playersCard.getPoint();
//        }
//        if (opponentsCard.getType().equals("Fighter")) {
//            hp = hp - opponentsCard.getPoint();
//        }
//
//        player.setHp(hp);
//        return hp;
//    }


}
