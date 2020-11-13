package com.powerpuff.cardgame.cardGame;

import java.util.List;

public class Game {
    Action action = new Action();
    Display display = new Display();
    public boolean gameOver = false;
    public Player player;
    public PlayerDeck playerDeck = new PlayerDeck();
    public List<Card> playerDeckList = playerDeck.getPlayerCards();
    public int hp;
    public int counter;
    public int game = 0;

    public Game(){
    }

    public void run() {

        //startGame/menu

        display.printEnterNameMessage();
        action.inputPlayerName();
        player = new Player();
        player.setName(action.playerName);

        //get cards for the player
        player.getHand().getPlayerDeck().getCardsFromGeneratedCards();


        randomStart();

        //game
        while (!gameOver){

            gameTurn();

            gameOver(hp, playerDeckList);

        }

    }

    public void playerTurn(){
        System.out.println("playerTurn");
        //print playername turn
        //print your cards in hand
        //input card choice
        //execute playedcard in playerclass/computerclass
        //execute delete onCard from hand
        //print witch card played
        //execute opponent hp - cardDamage
        //print opponent hp status
        //print playerHp status
        //execute drawOnCard from deck
        //execute delete oneCard from deck
       // display.printPlayerHp();


        //put in menu? print continue?
       // display.printEndMessage();
        //action.inputMenu();
        //endGame();
    }

    public void computerTurn(){
        System.out.println("computerTurn");
    }

    public void gameTurn(){


    }

    public int randomStart(){
        return counter = (int) (Math.random()*2);
    }


    public boolean gameOver(int hp, List<Card> playerDeckList) {
        hp = player.getHp();
        if (hp == 0 || playerDeckList.size() == 0) {
             gameOver = true;
        }
        return gameOver;
    }

    void endGame() {
        gameOver = true;
    }


}


