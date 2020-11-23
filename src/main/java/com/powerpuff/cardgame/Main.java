package com.powerpuff.cardgame;
import com.powerpuff.cardgame.cardGame.*;

public class Main {

    public static void main(String[] args) {
        new Game().run();
        Gameboard gameboard = new Gameboard();
        gameboard.placePlayerCardOnGameboard(new Card("Fighter", "Sofia", 1, 1));


    }
}
