package com.paytondev.BlackJack;

import java.util.ArrayList;

public class Dealer {

    private final ShoeDeck shoeDeck = new ShoeDeck();
    ArrayList<Card> playerDiscardPile = shoeDeck.getDiscardCards();
    private final PlayerHand dealerHand = new PlayerHand();
    ArrayList<Player> playerList;

    private boolean isBusted = false;

    public Dealer(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public boolean returnIsBusted() {
        return isBusted;
    }

    public void setBusted(boolean bust) {
        isBusted = bust;
    }

    public PlayerHand returnDealerHand() {
        return dealerHand;
    }

    public void dealCards() {
        for (int i = 0; i < 2; i++) {
            dealerHand.receiveCard(shoeDeck.dealCard());
            for (Player p : playerList) {
                p.receiveCard(shoeDeck.dealCard());
            }
        }
    }

    public Card dealSingleCard() {
        return shoeDeck.dealCard();

    }

    public void displayAllPlayerHands() {
        for (Player p : playerList) {
            System.out.println(p.getName() + ": " + p.playerHand.checkHand());
        }
    }

    public void returnCardsToShoe(int index) {
        shoeDeck.returnArrayOfCardsToShoe(playerList.get(index).playerHand.returnPlayerHand());

    }

    public void resetShoeDeck() {
        shoeDeck.addDiscardToShoe();
        shoeDeck.shuffleShoeDeck();
    }


    public void shuffleShoeDeck() {
        shoeDeck.shuffleShoeDeck();
    }


    public String displayDealerFirstCard() {
        return dealerHand.returnPlayerHand().get(0).toString();
    }

    public void displayDealerDeck() {
        dealerHand.displayPlayerHand();
    }


}
