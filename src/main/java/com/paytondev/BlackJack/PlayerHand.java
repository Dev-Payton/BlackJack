package com.paytondev.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {

    private final int TWENTY_ONE = 21;

    private int handCount = 0;


    private ArrayList<Card> playerHand = new ArrayList<>();

    public PlayerHand() {

    }

    public void receiveCard(Card card) {
        playerHand.add(card);
    }


    public void displayPlayerHand() {
        for (Card card : playerHand) {
            System.out.println("• " + card.toString());
        }
    }

    public List<Card> returnPlayerHand() {
        return new ArrayList<>(playerHand);
    }


    public void resetHand() {
        playerHand.clear();
    }

    public int checkHand() {
        int currentHand = 0;
        int aceCount = 0;


        for (Card c : playerHand) {
            currentHand += c.getRealFaceValue();
            if (c.getRealFaceValue() == 11)
                aceCount++;
        }

        while (currentHand > TWENTY_ONE && aceCount > 0) {

            currentHand -= 10;
            aceCount--;

        }

        return currentHand;

    }

    public String getHandToString() {
        return handCount + "";
    }

    public boolean checkBust() {
        return checkHand() > TWENTY_ONE;
    }


    public boolean isBlackJack() {
        return checkHand() == TWENTY_ONE && playerHand.size() == 2;
    }

}
