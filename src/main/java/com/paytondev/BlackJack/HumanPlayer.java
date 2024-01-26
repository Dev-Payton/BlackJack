package com.paytondev.BlackJack;

public class HumanPlayer extends Player{


    @Override
    public void recieveCard(Card card) {
        playerHand.receiveCard(card);
    }

    @Override
    public void playTurn() {
        super.playTurn();
    }
}
