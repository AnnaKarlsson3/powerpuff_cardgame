package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Display {

    //11.2 skapa tom metod printHP i Display-class, gör testmetod, gör klart metod
    Player player = new Player();
    public int hp = player.getHp();
    public String playerHp = "";
    public String enterNameMessage = "";
    Hand hand = new Hand();


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
        hand.getCardsInHand();
       return cardsInHand;
    }


    public List<String> addNumberCardsInHand(){
        ArrayList<Card> cardsInHand = hand.getCardsInHand();
        AtomicInteger numbers = new AtomicInteger(1);

        List<String> cardsList = cardsInHand.stream()
                .map(card -> numbers.getAndIncrement() + ". Name: " + card.getName()
                        + " Type: " + card.getType() + " Points: " + card.getPoint() + "\n")
                .collect(Collectors.toList());

        return cardsList;
    }



}
