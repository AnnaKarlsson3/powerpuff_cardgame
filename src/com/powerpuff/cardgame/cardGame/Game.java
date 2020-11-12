package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Action action = new Action();
    Display display = new Display();
    public boolean gameOver = false;
    public Player player;
    public PlayerDeck playerDeck;
    public List<Card> playerDeckList;
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
            display.printEnterNameMessage();
            action.inputPlayerName();

            display.printEndMessage();
            action.inputMenu();
            endGame();


            gameOver(hp, playerDeckList);
        }

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


