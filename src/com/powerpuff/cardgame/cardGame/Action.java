package com.powerpuff.cardgame.cardGame;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Action {

    //private static Game game = new Game();


    public String playerName = "";


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
                case 2:
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

        while (number > hand.cardsInHand.size()) {
            System.out.println("Invalid input");
            number = getIntInput();
        }
        return findCardByNumber(number, hand);

    }


    public Card findCardByNumber(int numberInHand, Hand hand) {
        Card card = hand.cardsInHand.get(numberInHand - 1);
        return card;

    }

}








