package com.powerpuff.cardgame.cardGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardGenerator {
    private ArrayList<Card> commonDeck = new ArrayList<>();
    public  ArrayList <Card> shuffledCards = (ArrayList<Card>) commonDeck.clone();

    private static final CardGenerator instance = new CardGenerator();
    public static CardGenerator getInstance(){
        return instance;
    }


    private CardGenerator() {
        generateCardsAndGet();
        shuffleCards(commonDeck);
        setCommonDeck(commonDeck);
    }

    public ArrayList<Card> generateCardsAndGet() {

        Path path = Paths.get("src/card.csv");
        List<String[]> cardsInfo = new ArrayList<>();
        try {
            cardsInfo = Files.lines(path)
                    .map(s -> s.split(";"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        commonDeck = new ArrayList<>();
        cardsInfo.forEach((cardInfo -> commonDeck.add(new Card(cardInfo[1], cardInfo[0], Integer.parseInt(cardInfo[2]), Integer.parseInt(cardInfo[3])))));
        return commonDeck;
    }

    public void setCommonDeck(ArrayList<Card> commonDeck) {
        this.commonDeck =  commonDeck;
    }

    public ArrayList<Card> getCommonDeck() {
        return commonDeck;

    }

    public ArrayList<Card> shuffleCards (ArrayList<Card> cards){
        Collections.shuffle(cards);
        return cards;
    }
}
