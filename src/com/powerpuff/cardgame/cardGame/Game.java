package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Action action = new Action();
    Display display;
    public boolean gameOver = false;
    public Player player;
    public Computer computer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> computerHand;




    public Game(){
        player = new Player();
        computer = new Computer();
        computer.setHp(20);
        player.setHp(20);
        display = new Display();
        System.out.println(player.getHand().getCardsInHand().size());
        System.out.println(player.getHand().getPlayerDeck().getPlayerCards().size());


    }

    public void run() {

        //startGame/menu

        display.printEnterNameMessage();
        action.inputPlayerName();
        player.setName(action.playerName);


        //get cards for the player
        //player.getHand().getPlayerDeck().getCardsFromGeneratedCards();



        //randomStart();

        //game
        while (!gameOver){


            playerTurn();

            gameOver();

            display.printEndMessage();

            action.inputMenu(this);
            if (gameOver) break;

            computerTurn();

                gameOver();
                if(gameOver == true){
                    break;
                }


        }
        display.printPlayAgain();
        Action.playAgain();




        //print hwo won

    }

   /* public int randomStart(){
        return counter = (int) (Math.random()*2);
    }*/



    public void playerTurn(){

        //print playername turn
        display.printPlayerName(player.getName());

        //print your cards in hand
        display.printCardsInHand(player.getHand().getCardsInHand());


        List<String> cardsinHandFromDisplay =  display.addNumberCardsInHand(player.getHand().getCardsInHand());

        //input card choice
        //display playedcard in playerclass/computerclass
        //display.formatCardToPlay(card);


        //execute opponent playerHp - cardDamage
        // updateHpIfPlayersTurn(card);

        //print playerHp status
        display.printPlayerHp(player.getHp());
        //print computer playerHp status
        display.printComputerHp(computer.getHp());


        //execute drawOnCard and delete oneCard from deck
        player.getHand().addNewCardToHand();

        //execute delete onCard from hand
        // player.getHand().deletePlayedCard(Card);




    }

    public void computerTurn(){
        display.printComputerTurn();

        //choose card to play
        Card playedCard = computer.playCard();
        if(playedCard == null){
            endGame();
        }

        //display played card
        display.formatCardToPlay(playedCard);

        updateHpIfComputersTurn(playedCard);

        //print playerHp status
        display.printPlayerHp(player.getHp());
        //print computer playerHp status
        display.printComputerHp(computer.getHp());

        //remove card from hand
        computer.getHand().deletePlayedCard(playedCard);

        //get onCardfrom hand and remove oneCard from Deck
        computer.getHand().addNewCardToHand();



    }



    public boolean gameOver() {
        playerHand = player.getHand().getCardsInHand();
        computerHand = computer.getHand().getCardsInHand();

        if (player.getHp() <= 0 || playerHand.size() == 0) {
            display.printWinner(computer);
            gameOver = true;
        }
        if (computer.getHp() <= 0 || computerHand.size() == 0) {
            display.printWinner(player);
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


//    public int updateHp(Player player, Card playersCard, Card opponentsCard) {
//        int hp = player.getHp();
//        if (playersCard.getType().equals("Action")) {
//            hp = hp + playersCard.getPoint();
//        }
//        if (opponentsCard.getType().equals("Fighter")) {
//            hp = hp - opponentsCard.getPoint();
//        }
//
//        player.setHp(hp);
//        return hp;
//    }


}
