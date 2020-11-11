package com.powerpuff.cardgame.cardGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardGenerator {

    private List<Card> commonDeck = new ArrayList<>();

    public CardGenerator() {
        generateCardsAndGet();
    }

    public List<Card> generateCardsAndGet() {
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
        cardsInfo.forEach((cardInfo -> commonDeck.add(new Card(cardInfo[1], cardInfo[0], Integer.parseInt(cardInfo[2])))));
        commonDeck.forEach(System.out::println);
        return commonDeck;
    }

    public void setCommonDeck(List<Card> commonDeck) {
        this.commonDeck = commonDeck;
    }

    public List<Card> getCommonDeck() {
        return commonDeck;
    }
}
