package com.powerpuff.cardgame.cardGame;

import java.util.List;
import java.util.Scanner;

public class Action {

    //private static Game game = new Game();


    public String playerName = "";



    public Action() {

    }


    public static void inputMenu(Game game) {
        Display display = new Display();
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        switch (action) {
            case 0:
                game.endGame();
                break;
            case 1:
                game.continueGame();
                break;

            default:
                System.out.println("Invalid");
                display.printEndMessage();
                inputMenu(game);


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
        Card card = hand.cardsInHand.get(numberInHand-1);
        return card;

    }

    public void checkInput(Game game){
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();

        if ( action.equals("y")){
          game.reStart();

        } if (action.equals("n")){
            game.endGame();
        }else{
            System.out.println("choose y/n");
            checkInput(game);
        }
    }

}








