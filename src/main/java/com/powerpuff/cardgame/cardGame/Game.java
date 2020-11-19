package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;

public class Game {
    Action action;
    Display display;
    public boolean gameOver = false;
    private Gameboard gameboard;
    public Player player;
    public Computer computer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> computerHand;

    public Game(){
        player = new Player();
        computer = new Computer();
        gameboard = new Gameboard();
        computer.setHp(20);
        player.setHp(20);
        display = new Display();
        action = new Action();
    }

    public void run() {



        setPlayerName();


        while (!gameOver) {

            playerTurn();
            display.printEndMessage();
            action.inputMenu(this);
            if (gameOver) break;

            computerTurn();
            gameOver();


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

        Card card = action.selectCard(player.getHand());

        System.out.println(" ");
        display.formatCardToPlay(card);
        System.out.println(" ");


        //check cardType

        //if cardsonboardList != null -{
        //display.printAttackMessage();
        //sout: display PLAYERBOARDLIST,
        //input: player choosing number/card to attack with,

        //-Computer choosing one card to block with/if its not null

        //if(blockCardList == null){setHP(attackpoints)}
        //else{attackmethod(attackCard, blockCard)}

        //}else display.printAttackMessageNoCardsAvailable();

        updateHpIfPlayersTurn(card);

        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());

        player.getHand().deletePlayedCard(card);

        player.getHand().addNewCardToHand();

        System.out.println("---------------------");
        System.out.println(" ");
    }

    public void computerTurn(){
        System.out.println("---------------------");
        display.printComputerTurn();

        //ComputerLogic
        computer.computerLogic(gameboard);



        Card playedCard = computer.playCard();
        if(playedCard == null){
            endGame();
        }

        System.out.println(" ");
        display.formatCardToPlay(playedCard);

        updateHpIfComputersTurn(playedCard);

        System.out.println(" ");
        display.printPlayerHp(player.getHp());
        display.printComputerHp(computer.getHp());


        System.out.println("---------------------");
        System.out.println(" ");
    }

    public boolean gameOver() {
        playerHand = player.getHand().getCardsInHand();
        computerHand = computer.getHand().getCardsInHand();

        if (player.getHp() <= 0 || playerHand.size() == 0) {
            if(player.getHp() < computer.getHp()){
                display.printWinner(computer);
            }
            if(player.getHp() == computer.getHp()){
                display.printTie();
            }
            gameOver = true;
        }
        if (computer.getHp() <= 0 || computerHand.size() == 0) {
            if(computer.getHp() < player.getHp()){
                display.printWinner(player);
            }
            if(computer.getHp() == player.getHp()){
                display.printTie();
            }

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

    public int updateHpIfPlayersTurn(Card playedCard) {
        int playerHp = player.getHp();
        if (playedCard.getType().equals("Action")) {
            playerHp = playerHp + playedCard.getPoint();
            player.setHp(playerHp);
        } else {
            computer.setHp(computer.getHp() - playedCard.getPoint());
        }
        return playerHp;
    }

    public int updateHpIfComputersTurn(Card playedCard) {
        int computerHp = computer.getHp();
        if (playedCard.getType().equals("Action")) {
            computerHp = computerHp + playedCard.getPoint();
            computer.setHp(computerHp);
        } else {
            player.setHp(player.getHp() - playedCard.getPoint());
        }
        return computerHp;
    }


}
