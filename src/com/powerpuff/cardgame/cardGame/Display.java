package com.powerpuff.cardgame.cardGame;

public class Display {

    public String enterNameMessage = "";

    public Display(){
        EnterNameMessage();
    }

    public void printEndMessage(){
        System.out.println("If you want to end game, press 0");
    }

    public void printEnterNameMessage(){
        System.out.println(enterNameMessage);
    }

    public String EnterNameMessage(){
       return enterNameMessage = "Enter player name:";
    }

}
