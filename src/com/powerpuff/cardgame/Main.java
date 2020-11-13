package com.powerpuff.cardgame;


import com.powerpuff.cardgame.cardGame.Computer;
import com.powerpuff.cardgame.cardGame.Game;
import com.powerpuff.cardgame.cardGame.Player;


public class Main {

    public static void main(String[] args) {
        new Game().run();
        Player player = new Player();
        Computer computer = new Computer();
        System.out.println(player.getName());
        System.out.println(computer.getName());


    }
}
