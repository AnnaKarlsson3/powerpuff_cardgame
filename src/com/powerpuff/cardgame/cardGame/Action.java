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
        Display display = new Display();
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        switch (action) {
            case 0:
                game.endGame();
                break;
            case 2:
                break;

            default:
                System.out.println("Invalid");
                display.printEndMessage();
                inputMenu();


        }
    }

    public String inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        return playerName = action;
    }


    public Card selectCard(Hand hand) {
     return null;


    }


    public Card findCardByNumber(int numberInHand, Hand hand) {
       return null;

    }

}








