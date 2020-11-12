package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.CardGenerator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class TestCardGenerator {
    CardGenerator cardGenerator;


    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        cardGenerator = new CardGenerator();
    }

    @Test
    void testGenerateCards() {
        Assertions.assertEquals( 100 ,cardGenerator.generateCardsAndGet().size() );
    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }

    @Test
        public void testShuffleMethod(){
        Card card1 = new Card("fighter", "banana", 5);
        Card card2 = new Card("fighter", "apple", 8);
        Card card3 = new Card("fighter","pear", 10 );

        List <Card> cardList = new ArrayList <Card>();
        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);

        Assertions.assertEquals(cardList, cardGenerator.shuffleCards(cardList));


        }


}
