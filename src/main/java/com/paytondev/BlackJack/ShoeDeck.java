package com.paytondev.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoeDeck {
    private final ArrayList<Card> sixDecksOfCards = new ArrayList<>();
    private final ArrayList<Card> discardCards = new ArrayList<>();


    public ShoeDeck() {
        setSixDecksOfCards();
        shuffleShoeDeck();
    }

    public Card dealCard() {
        Card card = sixDecksOfCards.get(0);
        sixDecksOfCards.remove(0);
        return card;
    }


    public ArrayList<Card> getDiscardCards() {
        return discardCards;
    }


    private void setSixDecksOfCards() {
        for (int i = 0; i < 6; i++) {
            for (int x = 1; x < 5; x++) {
                for (int j = 1; j < 14; j++) {
                    sixDecksOfCards.add(new Card(j, x));

                }
            }
        }
    }

    public void shuffleShoeDeck() {
        Collections.shuffle(sixDecksOfCards);
    }


    public void returnArrayOfCardsToShoe(List<Card> discardCards) {
        this.discardCards.addAll(discardCards);
    }

    public void addDiscardToShoe() {
        sixDecksOfCards.addAll(discardCards);
        discardCards.clear();
    }

}
