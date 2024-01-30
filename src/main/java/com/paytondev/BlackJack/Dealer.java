package com.paytondev.BlackJack;

import java.util.ArrayList;

public class Dealer {

    private ShoeDeck shoeDeck = new ShoeDeck();
    private  PlayerHand dealerHand = new PlayerHand();
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
            // IMPLEMENT NAMES HERE AND IMPLEMENT THE INVOLVED METHODS
        public void displayAllPlayerHands(){
            for (Player p : playerList){
                System.out.println();
                p.playerHand.displayPlayerHand();
            }
        }

    public void displayDealerFirstCard (){
        System.out.println(dealerHand.returnPlayerHand().get(0).toString());
    }

    public void displayDealerDeck (){
            dealerHand.displayPlayerHand();
    }



}
