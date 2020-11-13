package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Action action = new Action();
    Display display = new Display();
    private boolean isGameOver = false;
    private Player player;
    private Player computerPlayer;
    //public PlayerDeck playerDeck;
    //public List<Card> playerDeckList;
    //private int playerHp;


 //1.7 skapa metod InputPlayerName (create new player - gameClass)
    public Game(){
        this.player = new Player();
        this.computerPlayer = new Player();
        //this.playerHp = player.getHp();

        //this.playerDeck = new PlayerDeck();
        //this.playerDeckList = playerDeck.getPlayerCards();
    }

    public void run() {
        while (!isGameOver){


            //startGame
            display.printEnterNameMessage();
            action.inputPlayerName();

            System.out.println("lenght " + action.playerName);

            //gameTurn-loop
            display.printPlayerHp();
            gameOver(hp, playerDeckList);


            display.printEndMessage();
            action.inputMenu();
            endGame();
        }

        }


    public boolean gameOver(int hp, List<Card> playerDeckList) {
        if (hp == 0 || playerDeckList.size() == 0) {
             isGameOver = true;
        }
        return isGameOver;
    }

    void endGame() {
        isGameOver = true;
    }


}


