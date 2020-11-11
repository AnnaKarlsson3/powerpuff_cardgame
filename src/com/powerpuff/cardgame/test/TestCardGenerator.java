package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.CardGenerator;
import org.junit.jupiter.api.*;

public class TestCardGenerator {
    CardGenerator cardGenerator;


    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
        cardGenerator = new CardGenerator();
    }

    @Test
    void testGenerateCards() {
        Assertions.assertEquals( 100 ,cardGenerator.generateCards().size() );
    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }

}
