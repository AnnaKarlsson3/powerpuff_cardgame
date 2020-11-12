package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Game {
    Action action = new Action();
    Display display = new Display();

    //12.2 Skapa tom metod GameOver (boolean) (if hp is not 0 and cardDeck.lenght is not 0) = true i Game-class, gör test metod, gör klart metod

    public boolean gameOver = false;
    public Player player;
    public PlayerDeck playerDeck;
    public ArrayList<Card> playerDeckList;
    public int hp;


    public Game(){
        this.player = new Player();
        this.hp = player.getHp();
        this.playerDeck = new PlayerDeck();
        this.playerDeckList = playerDeck.getPlayerCards();
    }

    public void run() {
        while (!gameOver){
            display.printEndMessage();
            action.inputMenu();
            endGame();
            gameOver(hp, playerDeckList);
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


