package com.paytondev.BlackJack;

import java.util.ArrayList;

public class Dealer {

    private final ShoeDeck shoeDeck = new ShoeDeck();
    ArrayList<Card> playerDiscardPile = shoeDeck.getDiscardCards();
    private final PlayerHand dealerHand = new PlayerHand();
    ArrayList<Player> playerList;

        public Dealer(ArrayList<Player> playerList){
            this.playerList = playerList;
        }

        public void dealCards(){
            for (int i = 0; i < 2; i++){
                dealerHand.receiveCard(shoeDeck.dealCard());
                for (Player p : playerList){
                    p.receiveCard(shoeDeck.dealCard());
                }
            }
        }

        public Card dealSingleCard(){
            return shoeDeck.dealCard();

        }
        public void displayAllPlayerHands(){
            for (Player p : playerList){
                System.out.println(p.getName());
                p.playerHand.displayPlayerHand();
            }
        }

        public void returnCardsToShoe(int index){
            shoeDeck.returnArrayOfCardsToShoe(playerList.get(index).playerHand.returnPlayerHand());

        }

        public void resetShoeDeck(){
            shoeDeck.addDiscardToShoe();
            shoeDeck.shuffleShoeDeck();
        }



    public void displayDealerFirstCard (){
        System.out.println(dealerHand.returnPlayerHand().get(0).toString());
    }

    public void displayDealerDeck (){
            dealerHand.displayPlayerHand();
    }



}
