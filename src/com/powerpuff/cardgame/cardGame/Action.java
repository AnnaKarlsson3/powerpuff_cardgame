package com.powerpuff.cardgame.cardGame;

import java.util.Scanner;

public class Action {
    private static Game game = new Game();


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

    public static void inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        game.playerName = action;
    }
}








