package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Display {



    public String playerHp = "";
    public String enterNameMessage = "";
    public String playerNameTurn = "";


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
        System.out.println(name + playerNameTurn);
    }

    public String playerNameTurn(){
        return playerNameTurn = " it´s your turn!";
    }

    public void printComputerTurn(){
        printComputerTurnMessage();

    }

    public String printComputerTurnMessage(){
        return "";
    }

    public void printPlayerHp(int hp){
        printPlayerHpMessage();
        System.out.println(playerHp +hp);
    }

    public String printPlayerHpMessage(){ return playerHp = "Player HP is: "; }
    

    public List<String> addNumberCardsInHand(ArrayList<Card> cardsInHand){

        AtomicInteger numbers = new AtomicInteger(1);

        List<String> cardList = cardsInHand.stream()
                .map(card -> numbers.getAndIncrement() + ". Name: " + card.getName()
                        + " Type: " + card.getType() + " Points: " + card.getPoint() + "\n")
                .collect(Collectors.toList());
        return cardList;
    }

    public void printCardsInHand(ArrayList<Card> cardsInHand){

        List<String> numberedCards = addNumberCardsInHand(cardsInHand);

        String formattedCardsInHand = (String) numberedCards
                .stream()
                .collect(Collectors.joining("", "", ""));
        System.out.println(formattedCardsInHand);
    }

    public String getCardToPlay(Card chosenCardNr){
        return null;
    }

    public void printPlayedCard(){

    }

}
