package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.CardGenerator;
import org.junit.jupiter.api.*;


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
        Assertions.assertTrue(cardGenerator.cards != cardGenerator.shuffledCards);

        }


}
