package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Display {

    //11.2 skapa tom metod printHP i Display-class, gör testmetod, gör klart metod
    Player player = new Player();
    public int hp = player.getHp();
    public String playerHp = "";
    public String enterNameMessage = "";
    Hand h = new Hand();


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


    public ArrayList<Card> getCardsInHand (ArrayList<Card> cardsInHand ){
        h.getCardsInHand();
       return cardsInHand;
    }


    public List <String> addNumberCardsInHand(){
        return null;
    }



}
