package com.powerpuff.cardgame.cardGame;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Computer extends Player{

    Display display = new Display();

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

        Card playedCard = playCard();

        if( playedCard.getType().equals("Action")){
            setHp(getHp() + playedCard.getPoint());
            getHand().deletePlayedCard(playedCard);
            getHand().addNewCardToHand();
        } else {
            gameboard.placeComputerCardOnGameboard(playedCard);
        }

        display.formatCardToPlay(playedCard);

        attack(cardsOnBoardComputer, cardsOnBoardPlayer);




    }

    private Card attack(ArrayList<Card> cardsOnBoardComputer, ArrayList<Card> cardsOnBoardPlayer) {
        //I want to attack this card
       Card choosePlayersCard = cardsOnBoardPlayer.stream()
                                .max(Comparator.comparing(Card::getPoint))
                                .orElseThrow(NoSuchElementException::new);

    }


    public Card updateBlockPoint(){
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
