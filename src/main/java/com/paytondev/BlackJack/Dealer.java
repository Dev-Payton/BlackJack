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
                dealerHand.recieveCard(shoeDeck.dealCard());
                for (Player p : playerList){
                    p.recieveCard(shoeDeck.dealCard());
                }
            }
        }

    public void displayDealerFirstCard (){
        System.out.println(dealerHand.returnPlayerHand().get(0).toString());
    }

    public void displayDealerDeck (){
            dealerHand.displayPlayerHand();
    }



}
