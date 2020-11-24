package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
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
    String BOLD = "\u001b[1m";
    String RESET_COLOR = "\u001B[0m";
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String RED_BOLD = "\u001b[1m\u001b[38;5;197m";    // RED
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String PURPLE = "\u001b[1m\u001B[35m";
    public static final String PINK = "\u001b[1m\u001b[38;5;211m";
    public static final String LIGHT_PURPLE = "\u001b[1m\u001b[38;5;141m";


    public Display() {
        enterNameMessage();
    }

    public void printEndMessage() {
        System.out.println("To continue, press 1, to end game - press 0");
    }


    public void printRules(){
        printRulesMessage();
        System.out.println(printRules);
    }

    public String printRulesMessage(){
        return printRules = "Rules: \n *Player vs computer \n *You start round 1 randomly \n *Fighter-Cards has an attackPoint and a blockPoint, if you play an fighter-card you have to put it on the board \n " +
                "*Action-Cards has an healthPoint and 0 in blockPoints, if you play an action-card, it gives you life according to the healthPoints \n *You can not attack the first round \n" +
                "*If you have fighters-cards on the board, you have to attack \n *you can only attack with one fighter/round \n *If computer attacks and you have fighters-cards on board, you have to block \n " +
                "*If your block-cards blockPoints is less then computers attackPoints, or you don't have any block-cards, you will take damage \n *The card with less blockPoints than attackPoints will die in an attack/block \n " +
                "*You winn when computers health is 0 or it´s deck is empty \n *You loose when your health is 0 or your deck is empty ";
    }


    public void printEnterNameMessage() {
        System.out.println(enterNameMessage);
    }
    public String enterNameMessage() {
        return enterNameMessage = BOLD + "Enter player name: " + RESET_COLOR;
    }

    public void printPlayerName(String name) {
        playerNameTurn(name);
        System.out.println(playerNameTurn);
    }
    public String playerNameTurn(String name) {
        return playerNameTurn = BOLD + "It's your turn, " + name + RESET_COLOR;
    }

    public void printComputerTurn() {
        printComputerTurnMessage();
        System.out.println(computerTurn);
    }
    public String printComputerTurnMessage() {
        return computerTurn = "It's computer's turn.";
    }

    public void printaddHp(int point){
        System.out.println( point + " added to hp." + "\n");
    }

    public void printPlayerHp(int hp) {
        printPlayerHpMessage(hp);
        System.out.println(playerHp);
    }
    public String printPlayerHpMessage(int hp) {
        return playerHp = BOLD + "Player HP is: " + hp + RESET_COLOR;
    }

    public void printComputerHp(int hp) {
        printComputerHpMessage(hp);
        System.out.println(computerHp);
    }
    public String printComputerHpMessage(int hp) {
        return computerHp = BOLD + "Computer HP is: " + hp + RESET_COLOR;
    }

    public void printCards(ArrayList<Card> cards){
        System.out.println(printAsciiCards(cards));
    }

    private StringBuilder printAsciiCards(ArrayList<Card> cards) {
        StringBuilder asciiCards = new StringBuilder();


        AtomicInteger cardNumber = new AtomicInteger(1);
        AtomicInteger numberInsideCard = new AtomicInteger(1);
        AtomicInteger cardNumber2 = new AtomicInteger(1);

        asciiCards.append(cards
                .stream()
                .map(card -> PURPLE + cardNumber.getAndIncrement() + ". " + RESET_COLOR + card.getType() + ": " + card.getName())
                .collect(Collectors.joining(" | ")) + "\n");
        cards.stream().forEach(card -> asciiCards.append(" ┌──────────┐     "));
        asciiCards.append("\n");
        asciiCards.append(cards
                .stream()
                .map(card -> (card.getType().equals("Action") ? " │" + RED_BOLD + " ❤" : " │" + PINK + " \uD83D\uDCA5") + RESET + card.getPoint())
                .collect(Collectors.joining("      │     ")) + "      |\n");
        asciiCards.append(cards
                .stream()
                .map(card -> card.getType().equals("Action") ? " │    " : " │" + LIGHT_PURPLE + " ⛨" + RESET + card.getBlockPointPoint())
                .collect(Collectors.joining("      │     ")) + "      |\n");
        asciiCards.append(cards
                .stream()
                .map(card -> " │        " + PURPLE + numberInsideCard.getAndIncrement() + RESET_COLOR)
                .collect(Collectors.joining(" │     ")) + " "+ (numberInsideCard.toString().equals("5") ? " " : "" ) + "│\n");
        cards.stream().forEach(card -> asciiCards.append(" └──────────┘     "));
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
        System.out.println("Computer's cards on the board: \n");
        printCards(cards);
    }

    public void printPlayedCard(Card chosenCard) {
        if (chosenCard != null) {
            String point = "";
            String blockPoint = "    ";
            if (chosenCard.getType().equals("Action")) {
                point = RED_BOLD + " ❤" + RESET + chosenCard.getPoint();

            } else {
                point = YELLOW_BOLD + " \uD83D\uDCA5" + RESET + chosenCard.getPoint();
                blockPoint = YELLOW_BOLD + " ⛨" + RESET + chosenCard.getBlockPointPoint();

            }

            final StringBuilder asciiCard = new StringBuilder();
            asciiCard.append(chosenCard.getType() + ": " + chosenCard.getName() + "\n");
            asciiCard.append("┌───────────┐\n");
            asciiCard.append("│ " + point + "      │\n");
            asciiCard.append("│ " + blockPoint + "      │\n");
            asciiCard.append("│           │\n");
            asciiCard.append("└───────────┘\n");
            printPlayedCardMessage(asciiCard);

        }

    }

    public void printPlayedCardMessage(StringBuilder asciiCard) {
        System.out.println(asciiCard);
    }

    public void printWinner(Player player) {
        System.out.println(" ");
        System.out.println(GREEN_BOLD_BRIGHT+ "-------------- Game Over ----------------" + RESET);        System.out.println(" ");
        System.out.println("The Winner is:");
        System.out.println(player.getName());
    }

    public void printTie() {
        System.out.println(" ");
        System.out.println(GREEN_BOLD_BRIGHT+ "-------------- Game Over ----------------" + RESET);
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
        return displayAttackMessageNoCardsAvailable = "No attack cards left.";
    }

    public String printAttackMessageNoCardsAvailable() {
        System.out.println(attackMessageNoCardsAvailable());
        return null;
    }


    public  String computerNoCardsOnBoardMessage(){
        return computerNoCardsOnBoard ="Computer doesn't have any cards on the board";
    }

    public String printComputerNoCardsOnBoard() {
        System.out.println(computerNoCardsOnBoardMessage());
        return null;
    }

    public String computerPlayedActionCard() {
        return computerPlayedActionCard = "Computer played an Action card: ";
    }

    public String printComputerPlayedActionCard() {
        System.out.println(computerPlayedActionCard());
        return null;
    }

    public String computerPlacedFighterCard() {
        return computerPlayedFighterCard = "Computer placed a Fighter card on the Board";
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
        return computerNoAttackCard = "Computer doesn't have any cards to attack with.";
    }

    public String printNoAttackCardsComputer() {
        System.out.println(computerNoAttackCard);
        return null;
    }

}
