package com.powerpuff.cardgame.cardGame;

import java.util.List;
import java.util.Scanner;

public class Action {
    private static Game game = new Game();
    private List <Card> selectedCard = null;
    public String playerName = "";

    public Action(List<Card> selectedCardList) {


    }

    public Action() {

    }


    public static void inputMenu() {
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        switch (action){
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


    public Card selectCard(Card card) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch (number){
            case 1:
                findCardByNumber(0);
                break;
            case 2:
                findCardByNumber(1);
                break;

            case 3:
                findCardByNumber(2);
                break;

            case 4:
                findCardByNumber(3);
                break;

            case 5:
                findCardByNumber(4);
                break;

            default:  System.out.println("Invalid");
        }

        return card;

    }

    public int findCardByNumber(int numberInHand) {
       game.player.getHand().cardsInHand.get(numberInHand);
       
        return numberInHand;
    }
}








