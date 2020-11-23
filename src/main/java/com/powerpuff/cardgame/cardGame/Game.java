package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Game {
    Action action;
    Display display;
    public boolean gameOver = false;
    public Player player;
    public Computer computer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> computerHand;
    public Gameboard gameboard;
    public GameLogic gameLogic;
    //public Card selectedCardFromBoard = null;


    public Game(){
        player = new Player();
        computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        display = new Display();
        action = new Action();
        gameboard = new Gameboard();
        gameLogic = new GameLogic();


    }

    public void run() {



        setPlayerName();


        while (!gameOver) {

            playerTurn();
            display.printEndMessage();
            action.inputMenu(this);
            if (gameOver) break;

            computerTurn();
            gameOver(player.getHand().getCardsInHand(), player.getHp(), computer.getHand().getCardsInHand(), computer.getHp());


        }
        playAgain();

    }

    private void playAgain() {
        display.printPlayAgain();
        action.checkInput(this);


    }

    public void setPlayerName(){
        display.printEnterNameMessage();
        action.inputPlayerName();
        player.setName(action.playerName);
    }

    public void playerTurn(){
        System.out.println("---------------------");
        display.printPlayerName(player.getName());
        display.printCardsInHand(player.getHand().getCardsInHand());
        display.addNumbersToCards(player.getHand().getCardsInHand());

        Card selectedCardFromHand = action.selectCard(player.getHand());

        System.out.println(" ");
        display.formatCardToPlay(selectedCardFromHand);
        System.out.println(" ");



        gameLogic.manageSelectedCard(selectedCardFromHand, player, gameboard);

        if(gameboard.playerActiveCards.size() > 0 ) {

            display.printAttackMessage();

            display.printPlayersCardsOnBoard(gameboard.playerActiveCards);

            Card selectedCardFromBoard = action.selectCardFromBoard(gameboard);

             //computer blocking
             Card computerBlockingCard = computer.blockCard(selectedCardFromBoard, gameboard);
            System.out.println("computer blocking card: " + computerBlockingCard);

            //-Computer choosing one card to block with/if its not null
            if(gameboard.computerActiveCards.size() == 0) {
                computer.setHp(computer.getHp() - selectedCardFromBoard.getPoint());
            }else{gameLogic.attack(computer, selectedCardFromBoard, computerBlockingCard, gameboard.playerActiveCards, gameboard.computerActiveCards);}

        }
        else display.printAttackMessageNoCardsAvailable();

        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());

       // player.getHand().deletePlayedCard(selectedCardFromHand);

        //player.getHand().addNewCardToHand();

        System.out.println("---------------------");
        System.out.println(" ");
    }

    public void computerTurn(){
        System.out.println("---------------------");
        display.printComputerTurn();

        computer.computerSendToBoard(gameboard);

        if(gameboard.getComputerActiveCards().isEmpty() && computer.getHand().getCardsInHand().isEmpty()){
            endGame();
        }


        //System.out.println(gameboard.getPlayerActiveCards().toString());

        if(gameboard.computerActiveCards.size() > 0 ) {
            Card attackCard = computer.attackCard(gameboard);
            System.out.println("\ncomputer's attack card");
            System.out.println(attackCard);
            System.out.println("----------------------------------------------------");

            if (gameboard.playerActiveCards.size() == 0) {
                player.setHp(player.getHp() - attackCard.getPoint());
                System.out.println(" Player has no blockCard!");
            } else {
                display.printBlockMessage();
                display.printPlayersCardsOnBoard(gameboard.playerActiveCards);
                Card selectedCardFromBoard = action.selectCardFromBoard(gameboard);
                gameLogic.attack(player, attackCard, selectedCardFromBoard, gameboard.computerActiveCards, gameboard.playerActiveCards);
            }
            System.out.println(" ");
            display.formatCardToPlay(attackCard);
            computer.getHand().deletePlayedCard(attackCard);
        }
        else System.out.println("computer not having any Cards on board to attack with");

        System.out.println(" ");
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());

        //computer.getHand().addNewCardToHand();

        System.out.println("---------------------");
        System.out.println(" ");
    }

    public boolean gameOver(ArrayList<Card> playerHand, int playerHp, ArrayList<Card> computerHand, int computerHp) {

        if (playerHp <= 0 || playerHand.size() == 0) {
            gameOver = true;
        }
        if(computerHp <= 0 || computerHand.size() == 0){

            gameOver = true;
        }


        return gameOver;
    }

    void endGame() {
        gameOver = true;
    }

    public void continueGame() {
        gameOver = false;
    }

    void reStart () {
        Game game = new Game();
        game.run();
    }

    // might not be necessary
//    public int updateHpIfPlayersTurn(Card playedCard) {
//        int playerHp = player.getHp();
//        if (playedCard.getType().equals("Action")) {
//            playerHp = playerHp + playedCard.getPoint();
//            player.setHp(playerHp);
//        } else {
//            computer.setHp(computer.getHp() - playedCard.getPoint());
//        }
//        return playerHp;
//    }
//    // might not be necessary
//    public int updateHpIfComputersTurn(Card playedCard) {
//        int computerHp = computer.getHp();
//        if (playedCard.getType().equals("Action")) {
//            computerHp = computerHp + playedCard.getPoint();
//            computer.setHp(computerHp);
//        } else {
//            player.setHp(player.getHp() - playedCard.getPoint());
//        }
//        return computerHp;
//    }


}
