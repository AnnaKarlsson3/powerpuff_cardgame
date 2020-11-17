package com.powerpuff.cardgame.test;

import com.powerpuff.cardgame.cardGame.Card;
import com.powerpuff.cardgame.cardGame.Computer;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestComputer {
    Computer computer;

    @BeforeEach
    void init(){
        System.out.println("@BeforeEach executed");
        computer = new Computer();
    }

    @Test
    void testPlayCardTrue(){
        ArrayList<Card> cardsInHand = computer.getHand().cardsInHand;

        if(cardsInHand.isEmpty()){
            assertNull(computer.playCard());
        } else {
            assertNotNull(computer.playCard());
        }

    }

    @AfterEach
    void cleanUp(){
        System.out.println("@AfterEach executed");
    }
}
