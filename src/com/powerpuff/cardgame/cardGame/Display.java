package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Display {



    public String playerHp = "";
    public String enterNameMessage = "";
    public String playerNameTurn = "";
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


    public void printPlayerName(String name){
        playerNameTurn();
    }

    public String playerNameTurn(){
        return "";
    }

    public void printPlayerHp(int hp){
        printPlayerHpMessage();
        System.out.println(playerHp +hp);
    }

    public String printPlayerHpMessage(){ return playerHp = "Player HP is: "; }


    public ArrayList<Card> getCardsInHand (ArrayList<Card> cardsInHand ){
        h.getCardsInHand();
       return cardsInHand;
    }

    public void printCards(){
        System.out.println(h.cardsInHand);
    }













}
