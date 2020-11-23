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

    public void printCards(ArrayList<Card> cards){
        System.out.println(printAsciiCards(cards));
    }

    private StringBuilder printAsciiCards(ArrayList<Card> cards) {
        StringBuilder asciiCards = new StringBuilder();

        String PURPLE = "\u001B[35m";
        String RESET_COLOR = "\u001B[0m";

        asciiCards.append( PURPLE + "1." + RESET_COLOR + cards.get(0).getType() + " - " + cards.get(0).getName() + " | ");
        asciiCards.append( PURPLE + "2." + RESET_COLOR + cards.get(1).getType() + " - " + cards.get(1).getName() + " | ");
        asciiCards.append( PURPLE + "3." + RESET_COLOR + cards.get(2).getType() + " - " + cards.get(2).getName() + " | ");
        asciiCards.append( PURPLE + "4." + RESET_COLOR + cards.get(3).getType() + " - " + cards.get(3).getName() + " | ");
        asciiCards.append( PURPLE + "4." + RESET_COLOR + cards.get(4).getType() + " - " + cards.get(4).getName() + "\n");

        asciiCards.append(" ┌───────────┐   "); asciiCards.append("   ┌───────────┐   "); asciiCards.append("   ┌───────────┐   "); asciiCards.append("   ┌───────────┐   ");
        asciiCards.append("  ┌───────────┐\n");
        asciiCards.append(" │ \uD83D\uDCA5" + cards.get(0).getPoint() + "       │    ");asciiCards.append("  │ \uD83D\uDCA5" + cards.get(1).getPoint() + "       │   ");asciiCards.append("   │ \uD83D\uDCA5" + cards.get(2).getPoint() + "       │   ");asciiCards.append("   │ \uD83D\uDCA5" + cards.get(3).getPoint() + "       │   ");
        asciiCards.append("  │ \uD83D\uDCA5" + cards.get(4).getPoint() + "       │\n");
        asciiCards.append(" │ ⛨" + cards.get(0).getBlockPointPoint() + "       │ "); asciiCards.append("     │ ⛨" + cards.get(1).getBlockPointPoint() + "       │   ");asciiCards.append("   │ ⛨" + cards.get(2).getBlockPointPoint() + "       │   ");asciiCards.append("   │ ⛨" + cards.get(3).getBlockPointPoint() + "       │   ");
        asciiCards.append("  │ ⛨" + cards.get(4).getBlockPointPoint() + "       │\n");
        asciiCards.append(" │        " + PURPLE + "1" + RESET_COLOR + "  │ "); asciiCards.append("     │        " + PURPLE + "1" + RESET_COLOR + "  │   ");asciiCards.append("   │        " + PURPLE + "1" + RESET_COLOR + "  │   ");asciiCards.append("   │        " + PURPLE + "1" + RESET_COLOR + "  │   ");
        asciiCards.append("  │        " + PURPLE + "1" + RESET_COLOR + "  │\n");
        asciiCards.append(" └───────────┘ "); asciiCards.append("     └───────────┘   "); asciiCards.append("   └───────────┘   ");asciiCards.append("   └───────────┘   ");
        asciiCards.append("  └───────────┘ \n");
        return asciiCards;
    }


    public List<String> addNumbersToCards(ArrayList<Card> cardsInHand) {

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
    }

    public void printCardsInHand(ArrayList<Card> cardsInHand) {
        List<String> numberedCards = addNumbersToCards(cardsInHand);

        System.out.println("The cards in your hand:\n" + formatCards(numberedCards) +
                "\nWhat card do you want to play? Enter the number.\n");
    }

    public void printPlayersCardsOnBoard(ArrayList<Card> cards) {
        List<String> numberedCards = addNumbersToCards(cards);
        System.out.println("Your active cards: \n" + formatCards(numberedCards));
    }

    public void printComputersCardsOnBoard(ArrayList<Card> cards) {
        List<String> numberedCards = addNumbersToCards(cards);
        System.out.println("Computers active cards: \n" + formatCards(numberedCards));
    }

    public String formatCardToPlay(Card chosenCard) {
        String formattedCard = "Played card - Type: " + chosenCard.getType() + " - Name: " + chosenCard.getName() + " - Points: " + chosenCard.getPoint();
        return formattedCard;
    }

    public void printPlayedCard(Card chosenCard) {
        playedCard = formatCardToPlay(chosenCard);
        printPlayedCardMessage();
    }

    public void printPlayedCardMessage() {
        System.out.println(playedCard);
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

    public String printBlockMessageNoBlockCardsAvailable() {
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
}
