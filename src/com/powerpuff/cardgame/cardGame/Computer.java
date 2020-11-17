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
                    System.out.println(maxAction);
                    return maxAction;
                } catch (NoSuchElementException e) {
                    Card fighter = cardsInHand.stream()
                            .filter(c -> c.getType().startsWith("Fighter"))
                            .max(Comparator.comparing(Card::getPoint))
                            .orElseThrow(NoSuchElementException::new);
                    System.out.println(fighter);
                    return fighter;
                }
            } else {
                try {
                    Card maxFighter = cardsInHand.stream()
                            .filter(c -> c.getType().startsWith("Fighter"))
                            .max(Comparator.comparing(Card::getPoint))
                            .orElseThrow(NoSuchElementException::new);
                    System.out.println(maxFighter);
                    return maxFighter;
                } catch (NoSuchElementException e) {
                    Card action = cardsInHand.stream()
                            .filter(c -> c.getType().startsWith("Action"))
                            .max(Comparator.comparing(Card::getPoint))
                            .orElseThrow(NoSuchElementException::new);
                    System.out.println(action);
                    return action;
                }
            }
        } else {
            return null;
        }
    }

}
