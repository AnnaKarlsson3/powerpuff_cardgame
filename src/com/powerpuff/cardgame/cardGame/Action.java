package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Action {
    private static Game game = new Game();
    private List <Card> selectedCard = null;
    public String playerName = "";

    public Action(List<Card> selectedCardList) {
        selectedCardList.add((Card) selectedCard);

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
        return null;
    }

    public List<String> findCardByNumber(List<String> cardList) {
        return null;
    }
}








