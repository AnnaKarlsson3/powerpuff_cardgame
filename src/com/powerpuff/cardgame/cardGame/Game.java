package com.powerpuff.cardgame.cardGame;

public class Game {
    Action action = new Action();
    Display display = new Display();

    public boolean gameOver;

    public void run() {
        while (!gameOver){
            display.printEndMessage();
            action.inputMenu();
            endGame();

        }

    }

    void endGame() {
        gameOver = true;
    }

}
