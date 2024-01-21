package com.paytondev.BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class ShoeDeck {
    private ArrayList<Card> sixDecksOfCards = new ArrayList<>();
    private ArrayList<Card> discardCards = new ArrayList<>();



    public ShoeDeck(){
        setSixDecksOfCards();
        shuffleShoeDeck();
    }




    private void setSixDecksOfCards(){
        for (int i = 0; i < 6; i++ ){
            for (int x = 1; x < 5; x++){
                for (int j = 1; j < 14; j++){
                    sixDecksOfCards.add(new Card(j, x));

                }
            }
        }
    }

    public void shuffleShoeDeck(){
        Collections.shuffle(sixDecksOfCards);
    }

}
