package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Display {

    //11.2 skapa tom metod printHP i Display-class, gör testmetod, gör klart metod
    Player player = new Player();
    public int hp = player.getHp();
    public String playerHp = "";
    public String enterNameMessage = "";

    public Display(){
        enterNameMessage();
        printPlayerHpMessage();
    }

    public void printEndMessage(){
        System.out.println("If you want to end game, press 0");
    }


    public void printEnterNameMessage(){
        System.out.println(enterNameMessage);
    }

    public String enterNameMessage(){
       return enterNameMessage = "Enter player name:";
    }

    public void printPlayerHp(){
        System.out.println(playerHp);
    }

    public String printPlayerHpMessage(){ return playerHp = "Player HP is: " + hp; }

    public ArrayList<Hand> cardsInHand(ArrayList <Hand> cardsInHand ){
        return null;
    }

}
