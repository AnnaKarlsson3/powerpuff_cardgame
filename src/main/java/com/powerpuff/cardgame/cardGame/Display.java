package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Display {


    public String playerHp = "";
    public String computerHp ="";
    public String enterNameMessage = "";
    public String playerNameTurn = "";
    public String computerTurn = "";
    public String playedCard = "";
    public String displayBlockMessage = "";
    public String displayBlockMessageNoCardsAvaiilible = "";
    public String displayAttackMessage = "";


    public Display() {
        enterNameMessage();
    }

    public void printEndMessage() {
        System.out.println("To continue press 1, to end game, press 0");
    }


    public void printEnterNameMessage() {
        System.out.println(enterNameMessage);
    }

    public String enterNameMessage() {
        return enterNameMessage = "Enter player name:";
    }


    public void printPlayerName(String name) {
        playerNameTurn();
        System.out.println(name + playerNameTurn);
    }

    public String playerNameTurn() {
        return playerNameTurn = " it´s your turn!";
    }

    public void printComputerTurn() {
        printComputerTurnMessage();
        System.out.println(computerTurn);
    }

    public String printComputerTurnMessage() {
        return computerTurn = "computer´s turn!";
    }

    public void printPlayerHp(int hp) {
        printPlayerHpMessage();
        System.out.println(playerHp + hp);
    }

    public String printPlayerHpMessage() {
        return playerHp = "Player HP is: ";
    }

    public void printComputerHp(int hp) {
        printComputerHpMessage();
        System.out.println(computerHp + hp);
    }

    public String printComputerHpMessage() {
        return computerHp = "Computer HP is: ";
    }


    public List<String> addNumberCardsInHand(ArrayList<Card> cardsInHand) {

        AtomicInteger numbers = new AtomicInteger(1);

        List<String> cardList = cardsInHand.stream()
                .map(card -> numbers.getAndIncrement() + ". Type: " + card.getType()
                        + " - Name: " + card.getName() + " - Points: " + card.getPoint() + "\n")
                .collect(Collectors.toList());
        return cardList;
    }

    public void printCardsInHand(ArrayList<Card> cardsInHand) {
        List<String> numberedCards = addNumberCardsInHand(cardsInHand);

        String formattedCardsInHand = (String) numberedCards
                .stream()
                .collect(Collectors.joining("", "", ""));
        System.out.println("The cards in your hand:\n" + formattedCardsInHand +
                "\nWhat card do you want to play? Enter the number.\n");
    }

    public Card formatCardToPlay(Card chosenCard) {
        String formattedCard = "Played card - Type: " + chosenCard.getType() + " - Name: " + chosenCard.getName() + " - Points: " + chosenCard.getPoint();
        printPlayedCard(formattedCard);
        return chosenCard;
    }

    public void printPlayedCard(String cardToPrint) {
        playedCard = cardToPrint;
        printPlayedCardMessage();
    }

    public void printWinner(Player player){
        System.out.println(" ");
        System.out.println("------- Game Over -------");
        System.out.println(" ");
        System.out.println("The Winner is:");
        System.out.println(player.getName());
    }

    public void printTie(){
        System.out.println(" ");
        System.out.println("------- Game Over -------");
        System.out.println(" ");
        System.out.println("The game ended in a tie");
    }

    public void printPlayedCardMessage() {
        System.out.println(playedCard);
    }


    public void printPlayAgain(){
        System.out.println("Play again y/n?");
    }

    public String blockMessage(){ return displayBlockMessage = "Choose which card you want to block with"; }

    public String blockMessageNoBlockCardsAvailible(){ return displayBlockMessageNoCardsAvaiilible = "No block cards left"; }

    public String printBlockMessage(){
        System.out.println(blockMessage());
        return null;
    }

    public String printBlockMessageNoBlockCardsAvailable(){
        System.out.println(blockMessageNoBlockCardsAvailible());
        return null;
    }

    public String attackMessage() {
        return displayAttackMessage = "Choose attack card";
    }

    public String printAttackMessage(){
        System.out.println(attackMessage());
        return null;
    }

    public String attackMessageNoBlockCardsAvailable() {
        return null;
    }
}
