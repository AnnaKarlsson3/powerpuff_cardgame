package com.powerpuff.cardgame.cardGame;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Action {
    public String playerName = "";
    Display display = new Display();


    public Action() {

    }


    public void inputMenu(Game game) {
        Display display = new Display();
        boolean cont = true;
        while (cont) {
            int action = getIntInput();

            switch (action) {
                case 0:
                    game.endGame();
                    cont = false;
                    break;
                case 1:
                    game.continueGame();
                    cont = false;
                    break;

                default:
                    System.out.println("Invalid");
                    display.printEndMessage();
            }


        }

    }

    private int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Enter correct input");
        }
        return scanner.nextInt();
    }

    public String inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        return playerName = action;
    }


    public Card selectCard(Hand hand) {
        int number = getIntInput();

        while (number > hand.cardsInHand.size() || number == 0) {
            System.out.println("Invalid input");
            number = getIntInput();
        }
        return findCardByNumber(number, hand);

    }

    public Card selectCardFromBoard(Gameboard gameboard) {
        int number = getIntInput();

        while (number > gameboard.playerActiveCards.size() || number == 0) {
            System.out.println("Invalid input");
            number = getIntInput();
        }
        return findCardByNumberFromBoard(number, gameboard);

    }
    public Card findCardByNumberFromBoard (int numberInBoard, Gameboard gameboard) {
        Card card = gameboard.playerActiveCards.get(numberInBoard - 1);
        return card;

    }


    public Card findCardByNumber(int numberInHand, Hand hand) {
        Card card = hand.cardsInHand.get(numberInHand - 1);
        return card;

    }

    public void checkInput(Game game) {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();

        if (action.equals("y")) {
            game.reStart();

        }
        if (action.equals("n")) {
            game.endGame();
        } else {
            display.printPlayAgain();
            checkInput(game);
        }
    }

}








