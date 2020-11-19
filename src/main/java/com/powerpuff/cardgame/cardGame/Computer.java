package com.powerpuff.cardgame.cardGame;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Computer extends Player{

    public Computer() {
        super.setName("Computer");

    }

    public Computer(String name, int hp, Hand hand) {
        super(name, hp, hand);
    }


   public void computerSendToBoard(Gameboard gameboard){
        Card playedCard = playCard();

           if (playedCard.getType().equals("Action")) {
               setHp(getHp() + playedCard.getPoint());
               getHand().deletePlayedCard(playedCard);
               getHand().addNewCardToHand();
               System.out.println("Computer Played Action Card: ");
               System.out.println(playedCard);
               System.out.println("------------------------");
           } else {
               gameboard.placeComputerCardOnGameboard(playedCard);
               System.out.println("Computer placed a Fighter Card on the Board");
           }


    }

    Card attackCard(Gameboard gameboard) {
        ArrayList<Card> playersCards = gameboard.getPlayerActiveCards();
        ArrayList<Card> computersCards = gameboard.getComputerActiveCards();

        Card maxPlayersCard = playersCards.stream()
                .max(Comparator.comparing(Card::getPoint))
                .orElseThrow(NoSuchElementException::new);

        ArrayList<Card> options =  computersCards.stream()
                .filter(c -> c.getPoint() >= maxPlayersCard.getPoint())
                .collect(Collectors.toCollection(ArrayList::new));

        try {
            Card choosenCard = options.stream()
                    .min(Comparator.comparing(Card::getPoint))
                    .orElseThrow(NoSuchElementException::new);
            return choosenCard;
        } catch (NoSuchElementException e) {
            Card chooseMinCard = computersCards.stream()
                    .min(Comparator.comparing(Card::getPoint))
                    .orElseThrow(NoSuchElementException::new);
            return chooseMinCard;
        }
    }


    public Card blockCard(Card playersCard, Gameboard gameboard){
        ArrayList<Card> computersCards = gameboard.getComputerActiveCards();

        if(!computersCards.isEmpty()){
            ArrayList<Card> options =  computersCards.stream()
                    .filter(c -> c.getPoint() > playersCard.getPoint())
                    .collect(Collectors.toCollection(ArrayList::new));
            try {
                Card choosenCardToBlock = options.stream()
                        .min(Comparator.comparing(Card::getPoint))
                        .orElseThrow(NoSuchElementException::new);
                return choosenCardToBlock;
            } catch (NoSuchElementException e) {
                Card chooseMaxCard = computersCards.stream()
                        .max(Comparator.comparing(Card::getPoint))
                        .orElseThrow(NoSuchElementException::new);
                return chooseMaxCard;
            }
        } else{
            System.out.println("Computer doesn't have any card on board");
            return  null;
        }


    }

    public Card playCard(){
        int currentHp = getHp();
        ArrayList<Card> cardsInHand = hand.cardsInHand;

        if (!cardsInHand.isEmpty()) {
            if (currentHp < 10) {
                try {
                    Card maxAction = cardsInHand.stream()
                            .filter(c -> c.getType().startsWith("Action"))
                            .max(Comparator.comparing(Card::getPoint))
                            .orElseThrow(NoSuchElementException::new);
                    return maxAction;
                } catch (NoSuchElementException e) {
                    Card fighter = cardsInHand.stream()
                            .filter(c -> c.getType().startsWith("Fighter"))
                            .max(Comparator.comparing(Card::getPoint))
                            .orElseThrow(NoSuchElementException::new);
                    return fighter;
                }
            } else {
                try {
                    Card maxFighter = cardsInHand.stream()
                            .filter(c -> c.getType().startsWith("Fighter"))
                            .max(Comparator.comparing(Card::getPoint))
                            .orElseThrow(NoSuchElementException::new);
                    return maxFighter;
                } catch (NoSuchElementException e) {
                    Card action = cardsInHand.stream()
                            .filter(c -> c.getType().startsWith("Action"))
                            .max(Comparator.comparing(Card::getPoint))
                            .orElseThrow(NoSuchElementException::new);
                    return action;
                }
            }
        } else {
            return null;
        }
    }

}
