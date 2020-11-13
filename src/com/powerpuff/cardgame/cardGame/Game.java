package com.powerpuff.cardgame.cardGame;

import java.util.List;

public class Game {
    Action action = new Action();
    Display display;
    public boolean gameOver = false;
    public Player player;
    public Computer computer;
    public PlayerDeck playerDeck = new PlayerDeck();
    public List<Card> playerDeckList = playerDeck.getPlayerCards();
    public int playerHp;
    public int counter;


    public Game(){
        player = new Player();
        computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        playerHp = player.getHp();
        display = new Display();
    }

    public void run() {

        //startGame/menu



        display.printEnterNameMessage();
        action.inputPlayerName();
        player.setName(action.playerName);


        randomStart();

        //game
        while (!gameOver){

            gameTurn();

            gameOver(playerHp, playerDeckList);

        }

    }

    public void playerTurn(){
        System.out.println("playerTurn" + player.getName());
        //print playername turn
        //print your cards in hand
        //input card choice
        //execute playedcard in playerclass/computerclass
        //execute delete onCard from hand
        //print witch card played
        //execute opponent playerHp - cardDamage
        //print opponent playerHp status
        //print playerHp status
        //execute drawOnCard from deck
        //execute delete oneCard from deck
        display.printPlayerHp(playerHp);


        //put in menu? print continue?
       // display.printEndMessage();
        //action.inputMenu();
        //endGame();
    }

    public void computerTurn(){
        System.out.println("computerTurn");
        System.out.println("computer playerHp: " + computer.getHp());
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


    public boolean gameOver(int hp, List<Card> playerDeckList) {
        if (hp == 0 || playerDeckList.size() == 0) {
             gameOver = true;
        }
        return gameOver;
    }

    void endGame() {
        gameOver = true;
    }


}


