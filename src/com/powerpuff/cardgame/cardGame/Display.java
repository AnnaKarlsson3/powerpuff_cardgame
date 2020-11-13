package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Display {



    public String playerHp = "";
    public String enterNameMessage = "";
    Hand h = new Hand();


    public Display(){
        enterNameMessage();

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


    public void printPlayerHp(int hp){
        printPlayerHpMessage(hp);
        System.out.println(playerHp);
    }

    public String printPlayerHpMessage(int hp){ return playerHp = "Player HP is: " + hp; }


    public ArrayList<Card> getCardsInHand (ArrayList<Card> cardsInHand ){
        h.getCardsInHand();
       return cardsInHand;
    }

    public void printCards(){
        System.out.println(h.cardsInHand);
    }













}
