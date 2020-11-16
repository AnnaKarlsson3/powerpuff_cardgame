package com.powerpuff.cardgame.cardGame;

import java.util.List;
import java.util.Scanner;

public class Action {
    private static Game game = new Game();
    private List<Card> selectedCard = null;
    public String playerName = "";

    public Action(List<Card> selectedCardList) {


    }

    public Action() {

    }


    public static void inputMenu() {
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        switch (action) {
            case 0:
                game.endGame();
                break;

            default:
                System.out.println("Invalid");

        }
    }

    public String inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        return playerName = action;
    }


    public Card selectCard(Hand hand) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return findCardByNumber(number, hand);


    }


    public Card findCardByNumber(int numberInHand, Hand hand) {
        return hand.cardsInHand.get(numberInHand - 1);

    }

}








