package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Display {


    public String playerHp = "";
    public String computerHp = "";
    public String enterNameMessage = "";
    public String playerNameTurn = "";
    public String computerTurn = "";
    public String playedCard = "";
    public String displayBlockMessage = "";
    public String displayBlockMessageNoCardsAvailable = "";
    public String displayAttackMessage = "";
    public String displayAttackMessageNoCardsAvailable = "";
    public String computerNoCardsOnBoard = "";
    public String computerPlayedActionCard ="";
    public String computerPlayedFighterCard ="";
    public String breakLine = "";
    public String computerNoAttackCard = "";
    public String printRules = "";

    public Display() {
        enterNameMessage();
    }

    public void printEndMessage() {
        System.out.println("To continue press 1, to end game, press 0");
    }


    public void printRules(){
        printRulesMessage();
        System.out.println(printRules);
    }

    public String printRulesMessage(){
        return printRules;
    }


    public void printEnterNameMessage() {
        System.out.println(enterNameMessage);
    }
    public String enterNameMessage() {
        return enterNameMessage = "Enter player name: ";
    }

    public void printPlayerName(String name) {
        playerNameTurn(name);
        System.out.println(playerNameTurn);
    }
    public String playerNameTurn(String name) {
        return playerNameTurn = "It´s " + name + " turn";
    }

    public void printComputerTurn() {
        printComputerTurnMessage();
        System.out.println(computerTurn);
    }
    public String printComputerTurnMessage() {
        return computerTurn = "It´s computer´s turn";
    }

    public void printPlayerHp(int hp) {
        printPlayerHpMessage(hp);
        System.out.println(playerHp);
    }
    public String printPlayerHpMessage(int hp) {
        return playerHp = "Player HP is: " + hp;
    }

    public void printComputerHp(int hp) {
        printComputerHpMessage(hp);
        System.out.println(computerHp);
    }
    public String printComputerHpMessage(int hp) {
        return computerHp = "Computer HP is: " + hp;
    }

    public void printCards(ArrayList<Card> cards){
        System.out.println(printAsciiCards(cards));
    }

    private StringBuilder printAsciiCards(ArrayList<Card> cards) {
        StringBuilder asciiCards = new StringBuilder();

        String PURPLE = "\u001B[35m";
        String RESET_COLOR = "\u001B[0m";
        AtomicInteger cardNumber = new AtomicInteger(1);
        AtomicInteger numberInsideCard = new AtomicInteger(1);

        asciiCards.append(cards
                .stream()
                .map(card -> PURPLE + cardNumber.getAndIncrement() + ". " + RESET_COLOR + card.getType() + ": " + card.getName())
                .collect(Collectors.joining(" | ")) + "\n");
        cards.stream().forEach(card -> asciiCards.append(" ┌───────────┐     "));
        asciiCards.append("\n");
        asciiCards.append(cards
                .stream()
                .map(card -> " │ \uD83D\uDCA5" + card.getPoint())
                .collect(Collectors.joining("       │     ")) + "       |\n");
        asciiCards.append(cards
                .stream()
                .map(card -> " │ ⛨" + card.getBlockPointPoint())
                .collect(Collectors.joining("       │     ")) + "       |\n");
        asciiCards.append(cards
                .stream()
                .map(card -> " │        " + PURPLE + numberInsideCard.getAndIncrement() + RESET_COLOR)
                .collect(Collectors.joining("  │     ")) + "  │\n");
        cards.stream().forEach(card -> asciiCards.append(" └───────────┘     "));
        asciiCards.append("\n");
        return asciiCards;
    }


  /* public List<String> addNumbersToCards(ArrayList<Card> cardsInHand) {

        AtomicInteger numbers = new AtomicInteger(1);

        List<String> cardList = cardsInHand.stream()
                .map(card -> numbers.getAndIncrement() + ". Type: " + card.getType()
                        + " - Name: " + card.getName() + " - Points: " + card.getPoint() +" - block points: " + card.getBlockPointPoint() + "\n")
                .collect(Collectors.toList());
        return cardList;
    }

    public String formatCards(List<String> numberedCards) {
        String formattedCards = (String) numberedCards
                .stream()
                .collect(Collectors.joining("", "", ""));
        return formattedCards;
    }*/

    public void printCardsInHand(ArrayList<Card> cardsInHand) {
        System.out.printf("The cards in your hand:\n");
        printCards(cardsInHand);
        System.out.println("What card do you want to play? Enter the number.\n");
    }

    public void printPlayersCardsOnBoard(ArrayList<Card> cards) {
        System.out.println("Your cards on the board: \n");
        printCards(cards);
    }

    public void printComputersCardsOnBoard(ArrayList<Card> cards) {
        System.out.println("Computers active cards: \n");
        printCards(cards);
    }

    public void printPlayedCard(Card chosenCard) {

        final StringBuilder asciiCard = new StringBuilder();
        asciiCard.append(chosenCard.getType() + ": " + chosenCard.getName() + "\n");
        asciiCard.append("┌───────────┐\n");
        asciiCard.append("│ \uD83D\uDCA5" + chosenCard.getPoint() + "       │\n");
        asciiCard.append("│ ⛨" + chosenCard.getBlockPointPoint() + "       │\n");
        asciiCard.append("│           │\n");
        asciiCard.append("└───────────┘\n");
        printPlayedCardMessage(asciiCard);
    }

    public void printPlayedCardMessage(StringBuilder asciiCard) {
        System.out.println("\n" + asciiCard);
    }

    public void printWinner(Player player) {
        System.out.println(" ");
        System.out.println("------- Game Over -------");
        System.out.println(" ");
        System.out.println("The Winner is:");
        System.out.println(player.getName());
    }

    public void printTie() {
        System.out.println(" ");
        System.out.println("------- Game Over -------");
        System.out.println(" ");
        System.out.println("The game ended in a tie");
    }

    public void printPlayAgain() {
        System.out.println("Play again y/n?");
    }

    public String blockMessage() {
        return displayBlockMessage = "Choose which card you want to block with";
    }

    public String blockMessageNoBlockCardsAvailable() {
        return displayBlockMessageNoCardsAvailable = "No block cards left";
    }

    public String printBlockMessage() {
        System.out.println(blockMessage());
        return null;
    }

    public String printBlockMessageNoBlockCardsAvailable () {
        System.out.println(blockMessageNoBlockCardsAvailable());
        return null;
    }

    public String attackMessage() {
        return displayAttackMessage = "Choose attack card";
    }

    public String printAttackMessage() {
        System.out.println(attackMessage());
        return null;
    }

    public String attackMessageNoCardsAvailable() {
        return displayAttackMessageNoCardsAvailable = "No attack cards left";
    }

    public String printAttackMessageNoCardsAvailable() {
        System.out.println(attackMessageNoCardsAvailable());
        return null;
    }


    public  String computerNoCardsOnBoardMessage(){
        return computerNoCardsOnBoard ="Computer doesn't have any card on board";
    }

    public String printComputerNoCardsOnBoard() {
        System.out.println(computerNoCardsOnBoardMessage());
        return null;
    }

    public String computerPlayedActionCard() {
        return computerPlayedActionCard = "Computer Played Action Card: ";
    }

    public String printComputerPlayedActionCard() {
        System.out.println(computerPlayedActionCard());
        return null;
    }

    public String computerPlacedFighterCard() {
        return computerPlayedFighterCard = "Computer placed a Fighter Card on the Board";
    }

    public String printComputerPlacedFighterCard() {
        System.out.println(computerPlacedFighterCard());
        return null;
    }

    public String breakLineMessage() {
        return breakLine = "------------------------";
    }

    public String printBreakLine() {
        System.out.println(breakLineMessage());
        return null;
    }

    public String computerNoAttackCardsMessage() {
        return computerNoAttackCard = "computer is not having any cards on the board to attack with";
    }

    public String printNoAttackCardsComputer() {
        System.out.println(computerNoAttackCard);
        return null;
    }

}
