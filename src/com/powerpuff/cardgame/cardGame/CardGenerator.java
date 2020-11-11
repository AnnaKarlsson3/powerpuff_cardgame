package com.powerpuff.cardgame.cardGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardGenerator {

    public List<Card> generateCards(){
        Path path = Paths.get("src/card.csv");
        List<String[]> cardsInfo = new ArrayList<>();
        try {
            cardsInfo = Files.lines(path)
                    .map(s -> s.split(","))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Card> cards= new ArrayList<>();
        cardsInfo.forEach(cardInfo -> cards.add(new Card(cardInfo[0],Integer.parseInt(cardInfo[1]))));
        cards.forEach(System.out::println);
        return cards;
    }
}
