package com.paytondev.BlackJack;

import java.util.ArrayList;

public class PlayerCards {

    private  ArrayList<Card> playerHand = new ArrayList<>();



    public PlayerCards(){
    }






    public void displayPlayerHand(){
        for (Card card : PlayerHand){
            card.displayCard();
        }
    }

    public ArrayList<Card> getPlayerHand(){
        return playerHand;
    }


}
