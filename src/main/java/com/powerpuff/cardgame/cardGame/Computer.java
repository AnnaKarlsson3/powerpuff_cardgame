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

        if( playedCard.getType().equals("Action")){
            setHp(getHp() + playedCard.getPoint());
            getHand().deletePlayedCard(playedCard);
            getHand().addNewCardToHand();
        } else {
            gameboard.placeComputerCardOnGameboard(playedCard);
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


    public Card blockCard(){
        return null;
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
