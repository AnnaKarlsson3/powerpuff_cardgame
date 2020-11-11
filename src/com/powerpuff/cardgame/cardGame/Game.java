package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Game {

    //12.2 Skapa tom metod GameOver (boolean) (if hp is not 0 and cardDeck.lenght is not 0) = true i Game-class, gör test metod, gör klart metod

    public boolean gameOver = false;
    public Player player;
    public int hp;


    public Game(){
        this.player = new Player();
        this.hp = player.getHp();
        gameOver(hp);
    }

    public void run() {
        while (!gameOver){

        }

    }

    public boolean gameOver(int hp){
      return gameOver;
    }
}
