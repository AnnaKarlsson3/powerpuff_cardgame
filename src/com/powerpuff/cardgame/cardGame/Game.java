package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Game {
    Action action = new Action();
    Display display = new Display();
    public boolean gameOver = false;
    public Player player;
    public PlayerDeck playerDeck;
    public ArrayList<Card> playerDeckList;
    public int hp;
    String playerName;

 //1.7 skapa metod InputPlayerName (create new player - gameClass)
    public Game(){
        this.player = new Player();
        this.hp = player.getHp();
        this.playerDeck = new PlayerDeck();
        this.playerDeckList = playerDeck.getPlayerCards();
    }

    public void run() {
        while (!gameOver){


            //startGame
            display.printEnterNameMessage();
            action.inputPlayerName();

            //gameTurn-loop
            display.printPlayerHp();
            gameOver(hp, playerDeckList);


            display.printEndMessage();
            action.inputMenu();
            endGame();
        }

        }


    public boolean gameOver(int hp, ArrayList<Card> playerDeckList) {
        if (hp == 0 || playerDeckList.size() == 0) {
             gameOver = true;
        }
        return gameOver;
    }

    void endGame() {
        gameOver = true;
    }


}


