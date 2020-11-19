package com.powerpuff.cardgame.cardGame;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Computer extends Player{



    public Computer() {
        super.setName("Computer");

    }

    public Computer(String name, int hp, Hand hand) {
        super(name, hp, hand);
    }

    public void computerLogic(Gameboard gameboard){
        ArrayList<Card> cardsInHand = hand.cardsInHand;
        ArrayList<Card> cardsOnBoardPlayer = gameboard.getPlayerActiveCards();
        ArrayList<Card> cardsOnBoardComputer = gameboard.getComputerActiveCards();


        Card printthis = gameboard.placePlayerCardOnGameboard(setonBoard(cardsInHand));

        System.out.println("set card on board" + printthis);

    }

    private Card setonBoard(ArrayList<Card> cardsInHand) {
        if (!cardsInHand.isEmpty()) {
            return cardsInHand.stream()
                    .filter(c -> c.getType().startsWith("Fighter"))
                    .max(Comparator.comparing(Card::getBlockPointPoint))
                    .orElseThrow(NoSuchElementException::new);
        }
        return null;
    }




    public Card attack(){
        return null;
    }

    public Card block(){
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
