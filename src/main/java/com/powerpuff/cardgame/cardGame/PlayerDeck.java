package com.powerpuff.cardgame.cardGame;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlayerDeck {

    public ArrayList<Card> playerCards = new ArrayList<>();
    //public CardGenerator cardGenerator;
   //
    public Boolean isEmpty;

    public PlayerDeck(){
       // getCardsFromGeneratedCards();
        //System.out.println("commondeck size "+ commonDeck.size());

    }

    public ArrayList<Card> getCardsFromGeneratedCards(CardGenerator cardGenerator) {
        ArrayList<Card> commonDeck = cardGenerator.getCommonDeck();
        playerCards = (ArrayList<Card>) commonDeck.stream().limit(30).collect(Collectors.toList());
        removeFromCommonDeck(playerCards,commonDeck,cardGenerator);
        return playerCards;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public ArrayList<Card> removeFromCommonDeck(ArrayList<Card> playerCardsFromGen,ArrayList<Card> commonDeck, CardGenerator cardGenerator){

        commonDeck.removeAll(playerCardsFromGen);
        cardGenerator.setCommonDeck(commonDeck);
        return commonDeck;
    }


    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public boolean checkIfEmpty(ArrayList<Card> playerCards){
        if(playerCards == null){
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }
}
